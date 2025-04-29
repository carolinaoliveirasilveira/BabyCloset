package com.babycloset.layetteservice.service;

import com.babycloset.layetteservice.dto.ItemEventDTO;
import com.babycloset.layetteservice.dto.LayetteItemRequestDTO;
import com.babycloset.layetteservice.dto.LayetteItemResponseDTO;
import com.babycloset.layetteservice.entity.LayetteItem;
import com.babycloset.layetteservice.kafka.KafkaMessageProducer;
import com.babycloset.layetteservice.repository.LayetteItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LayetteItemService {

    private final LayetteItemRepository repository;
    private final KafkaMessageProducer kafkaMessageProducer;

    public LayetteItemService(LayetteItemRepository repository, KafkaMessageProducer kafkaMessageProducer) {
        this.repository = repository;
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    public LayetteItemResponseDTO create(LayetteItemRequestDTO dto) {
        LayetteItem item = LayetteItem.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .ageRange(dto.getAgeRange())
                .status(dto.getStatus())
                .addedAt(LocalDate.now())
                .build();

        LayetteItem savedItem = repository.save(item);

        // Envia mensagem para Kafka
        ItemEventDTO event = ItemEventDTO.builder()
                .service("layette-service")
                .id(savedItem.getId())
                .name(savedItem.getName())
                .status(savedItem.getStatus().name())
                .build();

        kafkaMessageProducer.sendMessage(event);

        return mapToResponse(savedItem);
    }

    public List<LayetteItemResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public LayetteItemResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private LayetteItemResponseDTO mapToResponse(LayetteItem item) {
        return LayetteItemResponseDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .category(item.getCategory())
                .ageRange(item.getAgeRange())
                .status(item.getStatus())
                .build();
    }
}

