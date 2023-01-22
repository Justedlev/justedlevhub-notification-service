package com.justedlev.jnotification.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "jnotification.service")
public class ServiceProperties {
    private String name;
    private String email;
    private String host;
}
