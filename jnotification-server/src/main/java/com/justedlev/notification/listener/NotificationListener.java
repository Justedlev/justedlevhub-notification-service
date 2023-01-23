package com.justedlev.notification.listener;

import com.justedlev.notification.model.request.SendMailTemplateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationListener {
    @RabbitListener(queues = "${cloudamqp.queue.send-template-mail}")
    public void sendTemplateMail(@Payload SendMailTemplateRequest request) {
        log.info("Received data: {}", request);
    }
}
