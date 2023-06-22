package com.carpi.vet.center.infraestructure.data.model;

import com.carpi.vet.person.infraestructure.data.model.PersonData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private PersonData person;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    private CenterData center;
    @Column(name = "initial_date_employee", nullable = false)
    private Date initialDate;
    @Column(name = "final_date_employee")
    private Date finalDate;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<EmployeeRolData> roles;
}
