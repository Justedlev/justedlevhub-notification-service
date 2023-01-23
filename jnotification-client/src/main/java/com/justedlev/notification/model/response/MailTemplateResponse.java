package com.justedlev.notification.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailTemplateResponse {
    private String name;
    private String template;
    private Timestamp createdAt;
}
