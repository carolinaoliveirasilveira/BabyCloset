package com.babycloset.exchangeservice.service;

import com.babycloset.exchangeservice.dto.ExchangeRequestDTO;
import com.babycloset.exchangeservice.dto.ExchangeResponseDTO;
import com.babycloset.exchangeservice.entity.Exchange;
import com.babycloset.exchangeservice.repository.ExchangeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeService {

    private final ExchangeRepository repository;

    public ExchangeService(ExchangeRepository repository) {
        this.repository = repository;
    }

    public ExchangeResponseDTO createExchange(ExchangeRequestDTO dto) {
        Exchange exchange = Exchange.builder()
                .itemName(dto.getItemName())
                .description(dto.getDescription())
                .ownerEmail(dto.getOwnerEmail())
                .status(dto.getStatus())
                .createdAt(LocalDateTime.now())
                .build();

        Exchange saved = repository.save(exchange);

        return toResponseDTO(saved);
    }

    public List<ExchangeResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private ExchangeResponseDTO toResponseDTO(Exchange exchange) {
        return ExchangeResponseDTO.builder()
                .id(exchange.getId())
                .itemName(exchange.getItemName())
                .description(exchange.getDescription())
                .ownerEmail(exchange.getOwnerEmail())
                .status(exchange.getStatus())
                .createdAt(exchange.getCreatedAt())
                .build();
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ExchangeResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Exchange not found with ID: " + id));
    }
}

