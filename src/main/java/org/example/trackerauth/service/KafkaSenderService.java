package org.example.trackerauth.service;

import lombok.RequiredArgsConstructor;
import org.example.trackerauth.config.kafka.KafkaProperties;
import org.example.trackerauth.dto.EmailLetterModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSenderService {
    private final KafkaTemplate<String, EmailLetterModel> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void sendMessageToKafka(EmailLetterModel emailLetterModel) {
        kafkaTemplate.send(kafkaProperties.getTopic(), emailLetterModel);
    }
}
