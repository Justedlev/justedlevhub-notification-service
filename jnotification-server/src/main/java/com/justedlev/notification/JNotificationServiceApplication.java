package com.justedlev.notification;

import com.justedlev.notification.properties.ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
        ServiceProperties.class,
})
public class JNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JNotificationServiceApplication.class, args);
    }

}
