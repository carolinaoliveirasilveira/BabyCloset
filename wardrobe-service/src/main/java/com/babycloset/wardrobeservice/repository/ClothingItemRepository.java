package com.babycloset.wardrobeservice.repository;

import com.babycloset.wardrobeservice.entity.ClothingItem;
import com.babycloset.wardrobeservice.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByCategory(Category category);
}
