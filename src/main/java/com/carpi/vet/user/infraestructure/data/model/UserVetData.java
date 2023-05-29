package com.carpi.vet.user.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVetData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", length = 250, nullable = false)
    private String email;
    @Column(name = "password", length = 72, nullable = false)
    private String password;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
}
