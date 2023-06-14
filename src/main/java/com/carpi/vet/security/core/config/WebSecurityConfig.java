package com.carpi.vet.security.core.config;

import com.carpi.vet.security.infraestructure.entrypoint.filters.BasicJWTAuthenticationFilter;
import com.carpi.vet.security.infraestructure.entrypoint.filters.JWTAuthorizationFilter;
import com.carpi.vet.security.infraestructure.entrypoint.filters.SocialJWTAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        BasicJWTAuthenticationFilter basicJWTAuthenticationFilter = new BasicJWTAuthenticationFilter();
        basicJWTAuthenticationFilter.setAuthenticationManager(authManager);
        basicJWTAuthenticationFilter.setFilterProcessesUrl("/login");

        SocialJWTAuthenticationFilter socialJWTAuthenticationFilter = new SocialJWTAuthenticationFilter();
        socialJWTAuthenticationFilter.setAuthenticationManager(authManager);
        socialJWTAuthenticationFilter.setFilterProcessesUrl("/slogin");

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers( "/api/v1/person/register").permitAll().
                                anyRequest().authenticated()).

                sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(basicJWTAuthenticationFilter)
                .addFilter(socialJWTAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
}
