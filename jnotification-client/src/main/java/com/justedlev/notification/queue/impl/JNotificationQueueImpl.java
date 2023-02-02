package com.justedlev.notification.queue.impl;

import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.queue.JNotificationQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JNotificationQueueImpl implements JNotificationQueue {
    private final AmqpTemplate amqpTemplate;
    @Value("${cloudamqp.queues.send-template-mail}")
    private String mailQueue;

    @Override
    public void sendEmail(SendMailTemplateRequest request) {
        amqpTemplate.convertAndSend(mailQueue, request);
    }
}
