package com.BabyCloset.wardrobe_service.controller;
import com.BabyCloset.wardrobe_service.kafka.KafkaProducerService;
import com.BabyCloset.wardrobe_service.model.ClothingItem;
import com.BabyCloset.wardrobe_service.service.ClothingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothingItemController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    private final ClothingItemService service;

    public ClothingItemController(ClothingItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClothingItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClothingItem> create(@RequestBody ClothingItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothingItem> update(@PathVariable Long id, @RequestBody ClothingItem item) {
        return ResponseEntity.ok(service.update(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendKafkaMessage(@RequestParam String msg) {
        kafkaProducerService.sendMessage("wardrobe-topic", msg);
        return ResponseEntity.ok("Mensagem enviada para o Kafka: " + msg);
    }
}
