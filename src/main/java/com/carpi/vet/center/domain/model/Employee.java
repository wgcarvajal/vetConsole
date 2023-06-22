package com.carpi.vet.center.domain.model;

import com.carpi.vet.person.domain.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Long id;
    private Person person;
    private Center center;
    private Date initialDate;
    private Date finalDate;
}
