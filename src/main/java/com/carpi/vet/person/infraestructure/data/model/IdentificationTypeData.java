package com.carpi.vet.person.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "identificationtype_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IdentificationTypeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_id_type", length = 30, nullable = false)
    private String name;
}
