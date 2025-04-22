package com.babycloset.wardrobeservice.service;

import com.babycloset.wardrobeservice.entity.ClothingItem;
import com.babycloset.wardrobeservice.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClothingItemService {

    private final ClothingItemRepository repository;

    public ClothingItemService(ClothingItemRepository repository) {
        this.repository = repository;
    }

    public ClothingItem create(ClothingItem item) {
        item.setAddedAt(LocalDate.now());
        item.setAvailable(true);
        return repository.save(item);
    }

    public List<ClothingItem> findAll() {
        return repository.findAll();
    }

    public ClothingItem findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public ClothingItem update(Long id, ClothingItem updatedItem) {
        ClothingItem existing = findById(id);
        existing.setDescription(updatedItem.getDescription());
        existing.setSize(updatedItem.getSize());
        existing.setCategory(updatedItem.getCategory());
        existing.setSeason(updatedItem.getSeason());
        existing.setAvailable(updatedItem.isAvailable());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
