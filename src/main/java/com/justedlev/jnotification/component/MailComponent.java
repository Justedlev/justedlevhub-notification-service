package com.justedlev.jnotification.component;

import com.justedlev.jnotification.component.command.SendEmailCommand;

public interface MailComponent {
    void sendConfirmActivationMail(SendEmailCommand command);
}
