package com.justedlev.notification.component;

import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;

public interface MailTemplateCreatorComponent {
    MailTemplateResponse create(CreateMailTemplateRequest request);
}
