package com.BabyCloset.wardrobe_service.service;

import com.BabyCloset.wardrobe_service.model.ClothingItem;
import com.BabyCloset.wardrobe_service.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingItemService {

    private final ClothingItemRepository repository;

    public ClothingItemService(ClothingItemRepository repository) {
        this.repository = repository;
    }

    public List<ClothingItem> findAll() {
        return repository.findAll();
    }

    public Optional<ClothingItem> findById(Long id) {
        return repository.findById(id);
    }

    public ClothingItem save(ClothingItem item) {
        return repository.save(item);
    }

    public ClothingItem update(Long id, ClothingItem item) {
        ClothingItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        existing.setType(item.getType());
        existing.setSize(item.getSize());
        existing.setColor(item.getColor());
        existing.setCondition(item.getCondition());
        existing.setAvailable(item.isAvailable());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}