package com.babycloset.exchangeservice.controller;

import com.babycloset.exchangeservice.dto.ExchangeRequestDTO;
import com.babycloset.exchangeservice.dto.ExchangeResponseDTO;
import com.babycloset.exchangeservice.entity.Exchange;
import com.babycloset.exchangeservice.service.ExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    private final ExchangeService service;

    public ExchangeController(ExchangeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExchangeResponseDTO> create(@RequestBody ExchangeRequestDTO dto) {
        return ResponseEntity.ok(service.createExchange(dto));
    }

    @GetMapping
    public ResponseEntity<List<ExchangeResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExchangeResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
