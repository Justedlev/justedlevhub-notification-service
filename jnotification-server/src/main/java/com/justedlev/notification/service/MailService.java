package com.justedlev.notification.service;

import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;
import com.justedlev.notification.model.response.SendMailTemplateResponse;

public interface MailService {
    SendMailTemplateResponse sendFromTemplate(SendMailTemplateRequest request);

    MailTemplateResponse createTemplate(CreateMailTemplateRequest request);
}
