package com.justedlev.hub.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CreateTemplateRequest {
    @NotNull
    @NotEmpty
    private String type;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    private String subject;
    @NotNull
    @NotEmpty
    private String template;
}
