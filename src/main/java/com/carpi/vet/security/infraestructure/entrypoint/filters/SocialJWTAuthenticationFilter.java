package com.carpi.vet.security.infraestructure.entrypoint.filters;

import com.carpi.vet.security.infraestructure.entrypoint.model.SocialAuthCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class SocialJWTAuthenticationFilter extends JWTAuthenticationFilter {
    @Override
    public Authentication getAuthentication(HttpServletRequest request) {
        SocialAuthCredentials authCredentials = new SocialAuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), SocialAuthCredentials.class);
        } catch (IOException e) {
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authCredentials, null);
        return authentication;
    }
}
