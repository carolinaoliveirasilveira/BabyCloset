package com.BabyCloset.wardrobe_service.repository;

import com.BabyCloset.wardrobe_service.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
}
