package com.babycloset.wardrobeservice.repository;

import com.babycloset.wardrobeservice.entity.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
}
