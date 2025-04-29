package com.babycloset.layetteservice.controller;
import com.babycloset.layetteservice.dto.LayetteItemRequestDTO;
import com.babycloset.layetteservice.dto.LayetteItemResponseDTO;
import com.babycloset.layetteservice.service.LayetteItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/layette")
public class LayetteItemController {

    private final LayetteItemService service;

    public LayetteItemController(LayetteItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LayetteItemResponseDTO> create(@RequestBody LayetteItemRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<LayetteItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LayetteItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}