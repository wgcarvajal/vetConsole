package com.carpi.vet.person.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="usertype_id")
    private UserTypeData userTypeData;
    @Column(name = "email_user", length = 100, nullable = false, unique = true)
    private String email;
    @Column(name = "password_user", length = 72)
    private String password;
}
