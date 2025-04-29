package com.babycloset.wardrobeservice.entity;

import com.babycloset.wardrobeservice.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String size;

    @Enumerated(EnumType.STRING)
    private Category category;
    private String season; // verão, inverno etc.
    private boolean available;
    private LocalDate addedAt;
}
