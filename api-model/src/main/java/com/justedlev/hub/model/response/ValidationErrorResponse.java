package com.justedlev.hub.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ValidationErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Builder.Default
    private Date timestamp = new Date();
    private String details;
    @Builder.Default
    private List<ViolationResponse> violations = new ArrayList<>();
}
