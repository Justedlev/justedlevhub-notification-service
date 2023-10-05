package com.justedlev.hub.controller;

import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.response.TemplateResponse;
import com.justedlev.hub.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/notifications")
@RequiredArgsConstructor
@Validated
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<TemplateResponse>> getAll() {
        return ResponseEntity.ok(notificationService.getAll());
    }

    @PostMapping
    public ResponseEntity<TemplateResponse> createTemplate(@Valid @RequestBody CreateTemplateRequest request) {
        var res = notificationService.createTemplate(request);

        return ResponseEntity.created(URI.create("/")).body(res);
    }
}
