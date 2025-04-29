package com.babycloset.layetteservice.entity;

import com.babycloset.layetteservice.enums.LayetteStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate addedAt;

}