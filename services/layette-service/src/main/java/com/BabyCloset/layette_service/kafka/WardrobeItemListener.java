package com.BabyCloset.layette_service.kafka;

import com.BabyCloset.layette_service.events.NewWardrobeItemEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WardrobeItemListener {

    @KafkaListener(topics = "wardrobe-item-created", groupId = "layette-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(NewWardrobeItemEvent event) {
        System.out.println("🎧 Novo item recebido do guarda-roupa: " + event.getName());
    }
}
