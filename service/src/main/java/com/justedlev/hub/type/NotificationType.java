package com.justedlev.hub.type;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationType {
    EMAIL("email"),
    PHONE("phone");

    @JsonValue
    private final String label;
}
