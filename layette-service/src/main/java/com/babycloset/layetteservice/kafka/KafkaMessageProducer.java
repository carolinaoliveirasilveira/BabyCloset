package com.babycloset.layetteservice.kafka;

import com.babycloset.layetteservice.dto.ItemEventDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaMessageProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);
    private static final String TOPIC = "item-events";

    private final KafkaTemplate<String, ItemEventDTO> kafkaTemplate;

    public void sendMessage(ItemEventDTO event) {
        log.info("Sending event to Kafka: {}", event);
        kafkaTemplate.send(TOPIC, event);
    }
}

