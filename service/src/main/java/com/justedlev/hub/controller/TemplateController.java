package com.justedlev.hub.controller;

import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.model.response.SentTemplateResponse;
import com.justedlev.hub.model.response.TemplateResponse;
import com.justedlev.hub.service.TemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Tag(name = "Template", description = "Endpoints for templated notification operations")
@RestController
@RequestMapping(value = "/v1/templates", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class TemplateController {
    private final TemplateService templateService;

    @Operation(summary = "Find the page of notification templates")
    @ApiResponse(responseCode = "200", description = "Found the page of notification templates")
    @GetMapping
    public ResponseEntity<Page<TemplateResponse>> findPage(@ParameterObject @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(templateService.findPage(pageable));
    }

    @Operation(summary = "Find the notification template")
    @ApiResponse(responseCode = "200", description = "Found the notification template")
    @GetMapping("/{name}")
    public ResponseEntity<TemplateResponse> findByName(@PathVariable String name) {
        return ResponseEntity.ok(templateService.getByName(name));
    }

    @Operation(summary = "Send the notification from template")
    @ApiResponse(responseCode = "200", description = "Successfully sent")
    @GetMapping("/send")
    public ResponseEntity<SentTemplateResponse> send(@Valid @RequestBody SendNotificationRequest request) {
        return ResponseEntity.ok(templateService.sendFromTemplate(request));
    }

    @Operation(summary = "Create the notification template")
    @ApiResponse(responseCode = "201", description = "Successfully created")
    @PostMapping
    public ResponseEntity<TemplateResponse> create(@Valid @RequestBody CreateTemplateRequest request) {
        var res = templateService.create(request);

        return ResponseEntity.created(URI.create("/" + res.getName())).body(res);
    }

    @Operation(summary = "Delete the notification template")
    @ApiResponse(responseCode = "204", description = "Successfully deleted")
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String name) {
        templateService.delete(name);

        return ResponseEntity.noContent().build();
    }
}
