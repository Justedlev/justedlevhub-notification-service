package com.justedlev.jnotification;

import com.justedlev.jnotification.properties.ServiceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ServiceProperties.class,
})
public class JnotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JnotificationServiceApplication.class, args);
    }

}
