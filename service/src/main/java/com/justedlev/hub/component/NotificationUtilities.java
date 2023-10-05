package com.justedlev.hub.component;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public class NotificationUtilities {
    public String buildBody(String template, Map<String, String> content) {
        return content.entrySet()
                .stream()
                .map(this::entryReplacer)
                .reduce(Function.identity(), Function::andThen)
                .apply(template);
    }

    private Function<String, String> entryReplacer(Map.Entry<String, String> entry) {
        return current -> current.replace(entry.getKey(), entry.getValue());
    }
}
