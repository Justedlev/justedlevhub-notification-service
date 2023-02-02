package com.justedlev.notification.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMailTemplateRequest {
    @NotNull
    @NotEmpty
    @Email
    private String recipient;
    @NotNull
    @NotEmpty
    @NotBlank
    private String templateName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String subject;
    private Map<String, String> content;
}
