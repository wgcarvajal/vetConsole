package com.carpi.vet.security.infraestructure.entrypoint.model;

import lombok.Data;

@Data
public class BasicAuthCredentials {
    private String email;
    private String password;
}
