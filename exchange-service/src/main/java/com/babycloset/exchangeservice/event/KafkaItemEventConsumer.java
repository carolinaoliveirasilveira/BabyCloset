package com.babycloset.exchangeservice.event;

import com.babycloset.exchangeservice.dto.ItemEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaItemEventConsumer {

    @KafkaListener(
            topics = "wardrobe-topic",
            groupId = "exchange-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(ItemEventDTO event) {
        log.info("🟢 Mensagem recebida do wardrobe-topic: {}", event);

    }
}

