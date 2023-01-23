package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailTemplateSenderComponent;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.model.response.SendMailTemplateResponse;
import com.justedlev.notification.properties.ServiceProperties;
import com.justedlev.notification.repository.MailTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailTemplateSenderComponentImpl implements MailTemplateSenderComponent {
    private final MailTemplateRepository mailTemplateRepository;
    private final ServiceProperties serviceProperties;
    private final JavaMailSender emailSender;

    @Override
    public SendMailTemplateResponse send(SendMailTemplateRequest request) {
        var mailTemplate = mailTemplateRepository.findByName(request.getTemplateName())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Template %s not exists", request.getTemplateName())));
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(serviceProperties.getEmail());
        simpleMailMessage.setTo(request.getRecipient());
        simpleMailMessage.setSubject(request.getSubject());
        simpleMailMessage.setText(createBody(mailTemplate.getTemplate(), request.getContent()));
        emailSender.send(simpleMailMessage);
        log.info("Mail send successfully completed");

        return SendMailTemplateResponse.builder()
                .recipient(request.getRecipient())
                .templateName(request.getTemplateName())
                .build();
    }

    private String createBody(String template, Map<String, String> content) {
        return content.entrySet()
                .stream()
                .map(this::replacerFunction)
                .reduce(Function.identity(), Function::andThen)
                .apply(template);
    }

    private Function<String, String> replacerFunction(Map.Entry<String, String> entry) {
        return current -> current.replace(entry.getKey(), entry.getValue());
    }
}
