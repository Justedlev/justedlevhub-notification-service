package com.justedlev.hub.service;

import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.model.response.SentTemplateResponse;
import com.justedlev.hub.model.response.TemplateResponse;

import java.util.List;

public interface NotificationService {
    List<TemplateResponse> getAll();

    SentTemplateResponse sendFromTemplate(SendNotificationRequest request);

    TemplateResponse createTemplate(CreateTemplateRequest request);
}
