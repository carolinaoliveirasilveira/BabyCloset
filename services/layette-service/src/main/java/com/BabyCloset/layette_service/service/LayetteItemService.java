package com.BabyCloset.layette_service.service;

import com.BabyCloset.layette_service.model.LayetteItem;
import com.BabyCloset.layette_service.repository.LayetteItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LayetteItemService {

    private final LayetteItemRepository repository;

    public LayetteItemService(LayetteItemRepository repository) {
        this.repository = repository;
    }

    public List<LayetteItem> findAll() {
        return repository.findAll();
    }

    public Optional<LayetteItem> findById(Long id) {
        return repository.findById(id);
    }

    public LayetteItem save(LayetteItem item) {
        return repository.save(item);
    }

    public LayetteItem update(Long id, LayetteItem item) {
        LayetteItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        existing.setItem(item.getItem());
        existing.setCategory(item.getCategory());
        existing.setQuantity(item.getQuantity());
        existing.setPurchased(item.isPurchased());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
