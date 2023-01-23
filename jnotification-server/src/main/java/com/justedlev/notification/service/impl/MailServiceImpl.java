package com.justedlev.notification.service.impl;

import com.justedlev.notification.component.MailTemplateCreatorComponent;
import com.justedlev.notification.component.MailTemplateSenderComponent;
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
    private final MailTemplateSenderComponent mailTemplateSenderComponent;
    private final MailTemplateCreatorComponent mailTemplateCreatorComponent;

    @Override
    public SendMailTemplateResponse sendFromTemplate(SendMailTemplateRequest request) {
        return mailTemplateSenderComponent.send(request);
    }

    @Override
    public MailTemplateResponse createTemplate(CreateMailTemplateRequest request) {
        return mailTemplateCreatorComponent.create(request);
    }
}
