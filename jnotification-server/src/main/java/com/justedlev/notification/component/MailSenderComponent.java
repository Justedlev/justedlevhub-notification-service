package com.justedlev.notification.component;

import com.justedlev.notification.model.request.SendMailTemplateRequest;

public interface MailSenderComponent {
    void send(SendMailTemplateRequest request);
}
