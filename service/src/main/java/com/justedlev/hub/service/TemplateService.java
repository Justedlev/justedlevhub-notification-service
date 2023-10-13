package com.justedlev.hub.service;

import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.model.response.SentTemplateResponse;
import com.justedlev.hub.model.response.TemplateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TemplateService {
    Page<TemplateResponse> findPage(Pageable pageable);

    SentTemplateResponse sendFromTemplate(SendNotificationRequest request);

    TemplateResponse create(CreateTemplateRequest request);

    void delete(String name);

    TemplateResponse getByName(String name);
}
