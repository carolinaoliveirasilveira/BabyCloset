package com.babycloset.exchangeservice.kafka;

import com.babycloset.exchangeservice.dto.ItemEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WardrobeLayetteEventListener {

    private static final Logger log = LoggerFactory.getLogger(WardrobeLayetteEventListener.class);

    @KafkaListener(topics = "wardrobe-items", groupId = "exchange-group", containerFactory = "kafkaListenerContainerFactory")
    public void fromWardrobe(ItemEventDTO event) {
        log.info("📦 Evento recebido do wardrobe: Item - {} | Status - {}", event.getName(), event.getStatus());
    }

    @KafkaListener(topics = "layette-items", groupId = "exchange-group", containerFactory = "kafkaListenerContainerFactory")
    public void fromLayette(ItemEventDTO event) {
        log.info("🎀 Evento recebido do layette: Item - {} | Status - {}", event.getName(), event.getStatus());
    }
}

