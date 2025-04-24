package com.babycloset.layetteservice.enums;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "layette_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayetteItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // Ex: roupas, higiene, alimentação
    private String ageRange; // Ex: recém-nascido, 3-6 meses, etc.

    @Enumerated(EnumType.STRING)
    private LayetteStatus status;
}