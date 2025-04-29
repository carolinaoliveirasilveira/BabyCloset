package com.babycloset.layetteservice.dto;

import com.babycloset.layetteservice.enums.LayetteStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LayetteItemResponseDTO {
    private Long id;
    private String name;
    private String category;
    private String ageRange;
    private LayetteStatus status;
}
