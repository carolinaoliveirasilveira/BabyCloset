package com.BabyCloset.wardrobe_service.controller;

import com.BabyCloset.wardrobe_service.event.NewWardrobeItemEvent;
import com.BabyCloset.wardrobe_service.kafka.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/wardrobe/events")
public class WardrobeEventController {

    private final KafkaProducerService kafkaProducerService;

    public WardrobeEventController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/create")
    public String createAndPublishEvent(@RequestBody NewWardrobeItemEvent event) {
        event.setItemId(UUID.randomUUID().toString());
        kafkaProducerService.publish(event);
        return "Evento publicado com sucesso!";
    }
}