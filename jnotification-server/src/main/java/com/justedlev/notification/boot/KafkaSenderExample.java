package com.justedlev.notification.boot;

import com.justedlev.notification.model.TemplateMailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaSenderExample implements ApplicationRunner {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    void sendMessage(String message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        kafkaTemplate.send("oowxuqiu-email-notification", TemplateMailRequest.builder()
                .templateName("templateName")
                .content(Map.of("{NAME}", "Edward L."))
                .recipient("edwardlyk@gmail.com")
                .build());
    }
}
