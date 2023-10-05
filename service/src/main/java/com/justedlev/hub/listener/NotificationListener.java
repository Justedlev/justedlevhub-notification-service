package com.justedlev.hub.listener;

import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${cloudamqp.queue.send-template-mail}")
    public void sendTemplateMail(@Payload SendNotificationRequest request) {
        try {
            notificationService.sendFromTemplate(request);
        } catch (Exception e) {
            log.error("Failed to send templated mail from payload: {}", request, e);
        }
    }
}
