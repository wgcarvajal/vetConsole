package com.carpi.vet.security.infraestructure.entrypoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    String authorization;
    String email;
    String name;
}
