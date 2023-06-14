package com.carpi.vet.security.infraestructure.entrypoint.filters;

import com.carpi.vet.security.infraestructure.entrypoint.model.BasicAuthCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public class BasicJWTAuthenticationFilter extends JWTAuthenticationFilter {
    @Override
    public Authentication getAuthentication(HttpServletRequest request) {
        System.out.println("ENTRO");
        BasicAuthCredentials authCredentials = new BasicAuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), BasicAuthCredentials.class);
        } catch (IOException e) {
        }
        System.out.println(authCredentials.toString());
        Authentication userNamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials, null);
        return userNamePAT;
    }
}
