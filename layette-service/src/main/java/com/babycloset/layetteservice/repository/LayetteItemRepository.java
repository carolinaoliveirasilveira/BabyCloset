package com.babycloset.layetteservice.repository;

import com.babycloset.layetteservice.entity.LayetteItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LayetteItemRepository extends JpaRepository<LayetteItem, Long> {
}
