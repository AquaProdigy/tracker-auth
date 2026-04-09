package org.example.trackerauth.dto;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String email,
        LocalDateTime created
) {}
