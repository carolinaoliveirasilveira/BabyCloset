package com.babycloset.exchangeservice.dto;

import com.babycloset.exchangeservice.enums.ExchangeStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExchangeResponseDTO {
    private Long id;
    private String itemName;
    private String description;
    private String ownerEmail;
    private ExchangeStatus status;
    private LocalDateTime createdAt;
}
