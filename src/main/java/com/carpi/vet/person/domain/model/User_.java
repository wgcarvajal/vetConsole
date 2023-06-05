package com.carpi.vet.person.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User_ {
    private Long id;
    private String email;
    private String password;
}
