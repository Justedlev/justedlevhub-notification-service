package com.justedlev.hub.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SentTemplateResponse {
    private String recipient;
    private String templateName;
    @Builder.Default
    private LocalDateTime sentAt = LocalDateTime.now();
}
