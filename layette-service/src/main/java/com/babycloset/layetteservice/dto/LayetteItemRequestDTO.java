package com.babycloset.layetteservice.dto;

import com.babycloset.layetteservice.enums.LayetteStatus;
import lombok.Data;

@Data
public class LayetteItemRequestDTO {
    private String name;
    private String category;
    private String ageRange;
    private LayetteStatus status;
}
