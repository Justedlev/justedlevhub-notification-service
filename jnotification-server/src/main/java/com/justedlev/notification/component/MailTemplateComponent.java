package com.justedlev.notification.component;

import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;
import com.justedlev.notification.model.response.SendMailTemplateResponse;

public interface MailTemplateComponent {
    MailTemplateResponse create(CreateMailTemplateRequest request);

    SendMailTemplateResponse send(SendMailTemplateRequest request);
}
