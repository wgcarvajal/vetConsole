package com.carpi.vet.center.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "rol_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_rol", length = 50,nullable = false)
    private String name;
}
