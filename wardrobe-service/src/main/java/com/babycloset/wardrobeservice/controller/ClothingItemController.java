package com.babycloset.wardrobeservice.controller;

import com.babycloset.wardrobeservice.dto.ClothingItemRequestDTO;
import com.babycloset.wardrobeservice.dto.ClothingItemResponseDTO;
import com.babycloset.wardrobeservice.enums.Category;
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
    public ResponseEntity<ClothingItemResponseDTO> create(@RequestBody ClothingItemRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClothingItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothingItemResponseDTO> update(@PathVariable Long id, @RequestBody ClothingItemRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ClothingItemResponseDTO>> getByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(service.findByCategory(category));
    }
}
