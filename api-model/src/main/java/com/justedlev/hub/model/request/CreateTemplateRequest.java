package com.justedlev.hub.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema
public class CreateTemplateRequest {
    @Schema(description = "Type of the notification template")
    @NotNull
    @NotEmpty
    private String type;

    @Schema(description = "Name of the notification template")
    @NotNull
    @NotEmpty
    private String name;

    @Schema(description = "Subject of the notification template")
    @NotNull
    @NotEmpty
    @NotBlank
    private String subject;

    @Schema(description = "Template value of the notification template")
    @NotNull
    @NotEmpty
    private String template;
}
