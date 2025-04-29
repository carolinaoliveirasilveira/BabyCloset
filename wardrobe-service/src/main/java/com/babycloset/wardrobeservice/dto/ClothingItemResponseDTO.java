package com.babycloset.wardrobeservice.dto;

import com.babycloset.wardrobeservice.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClothingItemResponseDTO {

    private Long id;
    private String description;
    private String size;
    private Category category;
    private String season;
    private boolean available;
    private LocalDate addedAt;
}
