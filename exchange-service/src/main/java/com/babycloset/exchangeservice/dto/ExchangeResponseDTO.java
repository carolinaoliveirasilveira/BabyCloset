package com.babycloset.exchangeservice.dto;

import com.babycloset.exchangeservice.enums.ExchangeStatus;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Data
@Builder
public class ExchangeResponseDTO {
    private Long id;
    private String itemName;
    private String description;
    private String ownerEmail;
    private ExchangeStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime createdAt;
}
