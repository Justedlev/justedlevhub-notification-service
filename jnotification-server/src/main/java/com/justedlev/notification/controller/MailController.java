package com.justedlev.notification.controller;

import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;
import com.justedlev.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
@Validated
public class MailController {
    private final MailService mailService;

    @PostMapping(value = "/create-template")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MailTemplateResponse> createTemplate(@Valid @RequestBody CreateMailTemplateRequest request) {
        return ResponseEntity.ok(mailService.createTemplate(request));
    }
}
