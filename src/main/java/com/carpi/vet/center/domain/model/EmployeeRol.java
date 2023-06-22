package com.carpi.vet.center.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeRol {

    private Long id;
    private Employee employee;
    private Rol rol;
}
