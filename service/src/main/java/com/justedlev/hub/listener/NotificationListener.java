package com.justedlev.hub.listener;

import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final TemplateService templateService;

    @RabbitListener(queues = "${cloudamqp.queue.send-template-mail}")
    public void sendTemplateMail(@Payload SendNotificationRequest request) {
        try {
            templateService.sendFromTemplate(request);
        } catch (Exception ex) {
            log.error("Failed to send templated notification: {}", request.getTemplateName());
            log.debug("Payload: {}", request);
            log.trace(ex.getMessage(), ex);
        }
    }
}
