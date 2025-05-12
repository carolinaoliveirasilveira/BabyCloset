package com.babycloset.exchangeservice.entity;

import com.babycloset.exchangeservice.enums.ExchangeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;

@Entity
@Table(name = "exchanges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private String ownerEmail;
    private ExchangeStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime createdAt;


}