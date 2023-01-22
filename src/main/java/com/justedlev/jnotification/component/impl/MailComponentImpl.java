package com.justedlev.jnotification.component.impl;

import com.justedlev.jnotification.component.MailComponent;
import com.justedlev.jnotification.component.command.SendEmailCommand;
import com.justedlev.jnotification.properties.ServiceProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailComponentImpl implements MailComponent {
    private final ServiceProperties serviceProperties;
    private final JavaMailSender emailSender;

    @Override
    public void sendConfirmActivationMail(SendEmailCommand command) {
        log.info("Starting to send email : receiver={}", to);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(serviceProperties.getEmail());
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(String.format(subject, serviceProperties.getName()));
        simpleMailMessage.setText(body);
        emailSender.send(simpleMailMessage);
        log.info("Mail send successfully completed");
    }
}
