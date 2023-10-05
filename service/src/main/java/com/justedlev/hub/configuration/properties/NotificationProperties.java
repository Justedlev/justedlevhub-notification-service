package com.justedlev.hub.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Getter
@Setter
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "configuration")
public class NotificationProperties {
    private String name;
    private String email;
}
