package com.carpi.vet.security.infraestructure.entrypoint.filters;

import com.carpi.vet.security.infraestructure.entrypoint.model.LoginResponse;
import com.carpi.vet.security.infraestructure.entrypoint.model.UserDetailsImpl;
import com.carpi.vet.security.utils.TokenUtils;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) {
        try {
            System.out.println("Authenticate");
            return getAuthenticationManager().authenticate(getAuthentication(request));
        } catch (AuthenticationException e) {
            System.out.println("error:"+e.getMessage());
            try {
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType(MediaType.TEXT_PLAIN_VALUE);
                PrintWriter writer = response.getWriter();
                writer.write(e.getMessage());
                writer.flush();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public abstract Authentication getAuthentication(HttpServletRequest request);

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String email = userDetails.getUsername();
        String name = userDetails.getName();
        String token = "Bearer " + TokenUtils.createToken(name, email);
        LoginResponse loginResponse = new LoginResponse(token, email, name);
        response.setContentType("Application/json");
        PrintWriter writer = response.getWriter();
        writer.write((new Gson()).toJson(loginResponse));
        writer.flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
