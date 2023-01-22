package com.justedlev.jnotification.listener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationListener {
    @KafkaListener(topics = "oowxuqiu-default")
    public void handle(A obj) {
        log.info("Received data: {}", obj);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class A {
        private String any;
    }
}
