package com.justedlev.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateMailRequest {
    private String recipient;
    private String templateName;
    private Map<String, String> content;
}
