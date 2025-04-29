package com.babycloset.wardrobeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEventDTO {
    private String serviceWardrobe;
    private Long id;
    private String name;
    private String status;
}
