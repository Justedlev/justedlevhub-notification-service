package com.justedlev.notification.component;

import com.justedlev.notification.component.command.SendMailCommand;

public interface MailSenderComponent {
    void send(SendMailCommand command);
}
