package com.justedlev.hub;

import com.justedlev.hub.configuration.properties.CloudAmqpProperties;
import com.justedlev.hub.configuration.properties.KeycloakProperties;
import com.justedlev.hub.configuration.properties.NotificationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
@EnableConfigurationProperties({
        NotificationProperties.class,
        CloudAmqpProperties.class,
        CloudAmqpProperties.Queue.class,
        KeycloakProperties.class,
        KeycloakProperties.JwtConverterProperties.class
})
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
