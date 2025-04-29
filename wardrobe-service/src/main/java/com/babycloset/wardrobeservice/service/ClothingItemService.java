package com.babycloset.wardrobeservice.service;

import com.babycloset.wardrobeservice.dto.ClothingItemRequestDTO;
import com.babycloset.wardrobeservice.dto.ClothingItemResponseDTO;
import com.babycloset.wardrobeservice.dto.ItemEventDTO;
import com.babycloset.wardrobeservice.entity.ClothingItem;
import com.babycloset.wardrobeservice.enums.Category;
import com.babycloset.wardrobeservice.kafka.KafkaMessageProducer;
import com.babycloset.wardrobeservice.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingItemService {

    private final ClothingItemRepository repository;
    private final KafkaMessageProducer kafkaMessageProducer;

    public ClothingItemService(ClothingItemRepository repository, KafkaMessageProducer kafkaMessageProducer) {
        this.repository = repository;
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    public ClothingItemResponseDTO create(ClothingItemRequestDTO dto) {
        ClothingItem item = ClothingItem.builder()
                .description(dto.getDescription())
                .size(dto.getSize())
                .category(dto.getCategory())
                .season(dto.getSeason())
                .available(true)
                .addedAt(LocalDate.now())
                .build();

        ClothingItem savedItem = repository.save(item);

        // Enviar evento para o Kafka
        ItemEventDTO event = ItemEventDTO.builder()
                .serviceWardrobe("wardrobe-service")
                .id(savedItem.getId())
                .name(savedItem.getDescription())
                .status(savedItem.isAvailable() ? "AVAILABLE" : "UNAVAILABLE")
                .build();

        kafkaMessageProducer.sendMessage(event);

        return toResponseDTO(savedItem);
    }

    public List<ClothingItemResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ClothingItemResponseDTO findById(Long id) {
        ClothingItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return toResponseDTO(item);
    }

    public ClothingItemResponseDTO update(Long id, ClothingItemRequestDTO dto) {
        ClothingItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        existing.setDescription(dto.getDescription());
        existing.setSize(dto.getSize());
        existing.setCategory(dto.getCategory());
        existing.setSeason(dto.getSeason());
        existing.setAvailable(dto.isAvailable());

        return toResponseDTO(repository.save(existing));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ClothingItemResponseDTO> findByCategory(Category category) {
        return repository.findByCategory(category).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private ClothingItemResponseDTO toResponseDTO(ClothingItem item) {
        ClothingItemResponseDTO dto = new ClothingItemResponseDTO();
        dto.setId(item.getId());
        dto.setDescription(item.getDescription());
        dto.setSize(item.getSize());
        dto.setCategory(item.getCategory());
        dto.setSeason(item.getSeason());
        dto.setAvailable(item.isAvailable());
        dto.setAddedAt(item.getAddedAt());
        return dto;
    }
}
