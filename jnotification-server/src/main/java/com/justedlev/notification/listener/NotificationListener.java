package com.justedlev.notification.listener;

import com.justedlev.notification.component.MailTemplateSenderComponent;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final MailTemplateSenderComponent mailTemplateSenderComponent;

    @RabbitListener(queues = "${cloudamqp.queue.send-template-mail}")
    public void sendTemplateMail(@Payload SendMailTemplateRequest request) {
        mailTemplateSenderComponent.send(request);
    }
}
