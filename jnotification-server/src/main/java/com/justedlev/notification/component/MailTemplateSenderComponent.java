package com.justedlev.notification.component;

import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.model.response.SendMailTemplateResponse;

public interface MailTemplateSenderComponent {
    SendMailTemplateResponse send(SendMailTemplateRequest request);
}
