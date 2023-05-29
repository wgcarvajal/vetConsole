package com.carpi.vet.user.core.config;

import com.carpi.vet.user.domain.port.UserVetPort;
import com.carpi.vet.user.domain.usecase.GetUserByEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserVetConfig {

    @Bean
    public GetUserByEmailUseCase getUserByEmailUseCase(UserVetPort userVetPort) {
        return new GetUserByEmailUseCase(userVetPort);
    }
}
