package com.justedlev.hub.component.impl;

import com.justedlev.hub.component.NotificationTemplateHandler;
import com.justedlev.hub.component.TemplateManager;
import com.justedlev.hub.component.command.NotificationCommand;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TemplateManagerImpl implements TemplateManager {
    private final Map<String, NotificationTemplateHandler> handlers;

    public TemplateManagerImpl(Set<NotificationTemplateHandler> handlers) {
        this.handlers = handlers.stream()
                .collect(Collectors.toMap(NotificationTemplateHandler::type, Function.identity()));
    }

    @Override
    public void assign(NotificationCommand command) {
        handlers.get(command.getType()).handle(command);
    }
}
