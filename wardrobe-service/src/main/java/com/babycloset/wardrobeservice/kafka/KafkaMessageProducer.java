package com.babycloset.wardrobeservice.kafka;

import com.babycloset.wardrobeservice.dto.ItemEventDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(ItemEventDTO event) {
        kafkaTemplate.send("wardrobe-topic", event);
    }
}

