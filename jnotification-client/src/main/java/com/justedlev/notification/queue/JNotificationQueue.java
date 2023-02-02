package com.justedlev.notification.queue;

import com.justedlev.notification.model.request.SendMailTemplateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public interface JNotificationQueue {
    void sendEmail(SendMailTemplateRequest request);
}
