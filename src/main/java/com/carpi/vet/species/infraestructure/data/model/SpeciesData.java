package com.carpi.vet.species.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "species_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpeciesData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_species", length = 30, nullable = false)
    private String name;
    @Column(nullable = false)
    private int state;
}
