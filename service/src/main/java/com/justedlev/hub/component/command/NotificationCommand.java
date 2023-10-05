package com.justedlev.hub.component.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCommand {
    private String type;
    private String subject;
    private String recipient;
    private String body;
}
