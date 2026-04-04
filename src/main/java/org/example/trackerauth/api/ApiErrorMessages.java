package org.example.trackerauth.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiErrorMessages {
    USER_NOT_FOUND("User not found"),
    INVALID_PASSWORD("Invalid password"),;

    private final String message;

}
