package org.example.trackerauth.dto.kafka;

public record EmailLetterKafkaDto(
        String email,
        String title,
        String description
) {}
