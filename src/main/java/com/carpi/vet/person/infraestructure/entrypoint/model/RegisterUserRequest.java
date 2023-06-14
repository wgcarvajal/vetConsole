package com.carpi.vet.person.infraestructure.entrypoint.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String name;
    private String LastName;
    private String email;
    private String password;
}
