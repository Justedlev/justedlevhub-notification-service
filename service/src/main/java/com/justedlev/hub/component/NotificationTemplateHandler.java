package com.justedlev.hub.component;

import com.justedlev.hub.component.command.NotificationCommand;

public interface NotificationTemplateHandler {
    String type();

    void handle(NotificationCommand command);
}
