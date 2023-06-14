package com.carpi.vet.security.infraestructure.entrypoint.model;

import lombok.Data;

@Data
public class SocialAuthCredentials {
    private String socialToken;
    private String provider;
}
