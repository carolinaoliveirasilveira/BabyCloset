package com.babycloset.exchangeservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String status; // e.g., "available", "exchanged"

    private LocalDateTime createdAt;
}