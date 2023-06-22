package com.carpi.vet.center.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "center_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CenterData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_cent", length = 100, nullable = false)
    private String name;
    @Column(name = "address_cent", length = 150, nullable = false)
    private String address;
    @Column(name = "phone_cent", length = 20, nullable = false)
    private String phone;
}
