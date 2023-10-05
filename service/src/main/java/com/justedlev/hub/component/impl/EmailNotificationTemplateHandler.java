package com.justedlev.hub.component.impl;

import com.justedlev.hub.component.NotificationTemplateHandler;
import com.justedlev.hub.component.command.NotificationCommand;
import com.justedlev.hub.configuration.properties.NotificationProperties;
import com.justedlev.hub.type.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailNotificationTemplateHandler implements NotificationTemplateHandler {
    private final NotificationProperties properties;
    private final JavaMailSender emailSender;

    @Override
    public String type() {
        return NotificationType.EMAIL.getLabel();
    }

    @Override
    public void handle(NotificationCommand command) {
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(properties.getEmail());
        simpleMailMessage.setTo(command.getRecipient());
        simpleMailMessage.setCc(properties.getEmail());
        simpleMailMessage.setSubject(command.getSubject());
        simpleMailMessage.setText(command.getBody());
        emailSender.send(simpleMailMessage);
        log.info("Mail sent successfully completed to '{}'", command.getRecipient());
    }
}
