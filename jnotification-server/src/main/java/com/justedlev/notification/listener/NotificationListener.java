package com.justedlev.notification.listener;

import com.justedlev.notification.model.TemplateMailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationListener {
    @KafkaListener(topics = "${jnotification.queue.email-topic}")
    public void handle(TemplateMailRequest request) {
        log.info("Received data: {}", request);
    }

}
