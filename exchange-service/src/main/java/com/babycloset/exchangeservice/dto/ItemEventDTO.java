package com.babycloset.exchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemEventDTO {
    private String service;
    private Long id;
    private String name;
    private String status;
}
