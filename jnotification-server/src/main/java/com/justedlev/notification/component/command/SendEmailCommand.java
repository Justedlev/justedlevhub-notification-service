package com.justedlev.notification.component.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendEmailCommand {
    private String recipient;
    private String templateName;
    private Map<String, String> content;
}
