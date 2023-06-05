package com.carpi.vet.person.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private Long id;
    private User_ user;
    private IdentificationType identificationType;
    private String identification;
    private String name;
    private String lastName;
    private String address;
    private String phone;
}
