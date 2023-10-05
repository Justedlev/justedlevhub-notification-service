package com.justedlev.hub.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendNotificationRequest implements Serializable {
    @NotNull
    private String type;
    @NotNull
    @NotEmpty
    private String recipient;
    @NotNull
    @NotEmpty
    @NotBlank
    private String templateName;
    private String subject;
    @NotNull
    @Builder.Default
    private Map<String, String> content = Collections.emptyMap();
}
