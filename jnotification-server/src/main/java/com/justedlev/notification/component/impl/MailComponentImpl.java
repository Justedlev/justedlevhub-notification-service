package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailComponent;
import com.justedlev.notification.component.command.SendEmailCommand;
import com.justedlev.notification.properties.ServiceProperties;
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
    public void send(SendEmailCommand command) {
        log.info("Starting to send email : receiver={}", command.getRecipient());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(serviceProperties.getEmail());
        simpleMailMessage.setTo(command.getRecipient());
        emailSender.send(simpleMailMessage);
        log.info("Mail send successfully completed");
    }
}
