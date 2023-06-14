package com.carpi.vet.person.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usertype_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTypeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "usertype_name", length = 20, nullable = false)
    private String name;
}
