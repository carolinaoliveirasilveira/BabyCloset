package com.BabyCloset.layette_service.controller;

import com.BabyCloset.layette_service.model.LayetteItem;
import com.BabyCloset.layette_service.service.LayetteItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/layette")
public class LayetteItemController {

    private final LayetteItemService service;

    public LayetteItemController(LayetteItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LayetteItem>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LayetteItem> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LayetteItem> create(@RequestBody LayetteItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LayetteItem> update(@PathVariable Long id, @RequestBody LayetteItem item) {
        return ResponseEntity.ok(service.update(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
