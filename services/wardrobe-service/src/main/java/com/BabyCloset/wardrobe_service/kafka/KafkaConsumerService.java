package com.BabyCloset.wardrobe_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "wardrobe-topic", groupId = "wardrobe-group")
    public void listen(String message) {
        System.out.println("📩 Mensagem recebida no wardrobe-topic: " + message);
    }
}
