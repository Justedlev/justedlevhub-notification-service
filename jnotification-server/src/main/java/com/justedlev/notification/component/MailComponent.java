package com.justedlev.notification.component;

import com.justedlev.notification.component.command.SendEmailCommand;

public interface MailComponent {
    void send(SendEmailCommand command);
}
