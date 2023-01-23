package com.justedlev.notification.service.impl;

import com.justedlev.notification.component.MailTemplateComponent;
import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;
import com.justedlev.notification.model.response.SendMailTemplateResponse;
import com.justedlev.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final MailTemplateComponent mailTemplateComponent;

    @Override
    public SendMailTemplateResponse sendFromTemplate(SendMailTemplateRequest request) {
        return mailTemplateComponent.send(request);
    }

    @Override
    public MailTemplateResponse createTemplate(CreateMailTemplateRequest request) {
        return mailTemplateComponent.create(request);
    }
}
