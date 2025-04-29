package com.babycloset.wardrobeservice.dto;

import com.babycloset.wardrobeservice.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothingItemRequestDTO {

    private String description;
    private String size;
    private Category category;
    private String season;
    private boolean available;
}
