package org.example.trackerauth.service;

import org.example.trackerauth.dto.EmailLetterModel;

public interface KafkaSenderService {
    void sendMessageToKafka(EmailLetterModel emailLetterModel);
}
