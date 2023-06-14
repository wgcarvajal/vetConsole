package com.carpi.vet.person.infraestructure.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserData user;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="id_type")
    private IdentificationTypeData identificationType;
    @Column(name = "identification_person", length = 15, unique = true)
    private String identification;
    @Column(name = "name_person", length = 40, nullable = false)
    private String name;
    @Column(name = "last_name_person", length = 40, nullable = false)
    private String lastName;
    @Column(name = "address_person", length = 90)
    private String address;
    @Column(name = "phone_person", length = 20)
    private String phone;

}
