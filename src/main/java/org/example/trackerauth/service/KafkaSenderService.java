package org.example.trackerauth.service;

import org.example.trackerauth.dto.kafka.EmailLetterKafkaDto;

public interface KafkaSenderService {
    void sendMessageToKafka(EmailLetterKafkaDto emailLetterModel);
}
