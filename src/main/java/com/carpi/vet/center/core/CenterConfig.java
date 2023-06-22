package com.carpi.vet.center.core;

import com.carpi.vet.center.domain.port.CenterPort;
import com.carpi.vet.center.domain.usecase.GetEmployeesByEmailAndRolUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CenterConfig {
    @Bean
    public GetEmployeesByEmailAndRolUseCase employeesByEmailAndRolUseCase(CenterPort port) {
        return new GetEmployeesByEmailAndRolUseCase(port);
    }
}
