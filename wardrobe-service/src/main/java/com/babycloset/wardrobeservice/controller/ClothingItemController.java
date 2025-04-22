package com.babycloset.wardrobeservice.controller;

import com.babycloset.wardrobeservice.entity.ClothingItem;
import com.babycloset.wardrobeservice.service.ClothingItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wardrobe")
public class ClothingItemController {

    private final ClothingItemService service;

    public ClothingItemController(ClothingItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClothingItem> create(@RequestBody ClothingItem item) {
        return ResponseEntity.ok(service.create(item));
    }

    @GetMapping
    public ResponseEntity<List<ClothingItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
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
}