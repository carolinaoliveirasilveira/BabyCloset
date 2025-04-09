package com.BabyCloset.wardrobe_service.kafka;

import com.BabyCloset.wardrobe_service.event.NewWardrobeItemEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, NewWardrobeItemEvent> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, NewWardrobeItemEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(NewWardrobeItemEvent event) {
        kafkaTemplate.send("wardrobe-item-created", event);
        System.out.println("📤 Evento publicado no tópico wardrobe-item-created: " + event.getName());
    }
}
