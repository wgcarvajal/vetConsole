package com.carpi.vet.security.core.config;

import com.carpi.vet.security.domain.port.ProvidersPort;
import com.carpi.vet.security.domain.port.SocialDetailService;
import com.carpi.vet.security.domain.usecase.LoadUserByEmailOrRegisterUserUseCase;
import com.carpi.vet.security.domain.usecase.LoadUserByUsernameUseCase;
import com.carpi.vet.security.infraestructure.entrypoint.CustomProvider;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    @Bean
    public LoadUserByEmailOrRegisterUserUseCase getLoadUserByEmailOrRegisterUserUseCase(SocialDetailService socialDetailService) {
        return new LoadUserByEmailOrRegisterUserUseCase(socialDetailService);
    }

    @Bean
    public LoadUserByUsernameUseCase getLoadUserByUsernameUseCase(@Qualifier("basicUserDetailService") UserDetailsService userDetailsService) {
        return new LoadUserByUsernameUseCase(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CustomProvider getCustomProvider(@Qualifier("basicProvider")ProvidersPort basicProvider,@Qualifier("googleProvider")ProvidersPort googleProvider) {
        HashMap<String, ProvidersPort> map = new HashMap<>();
        map.put("Basic",basicProvider);
        map.put("Google",googleProvider);
        return new CustomProvider(map);
    }


}
