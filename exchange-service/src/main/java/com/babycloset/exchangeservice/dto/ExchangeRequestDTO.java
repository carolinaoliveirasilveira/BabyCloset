package com.babycloset.exchangeservice.dto;

import com.babycloset.exchangeservice.enums.ExchangeStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExchangeRequestDTO {
    private String itemName;
    private String description;
    private String ownerEmail;
    private ExchangeStatus status;
    private LocalDateTime createdAt;
}