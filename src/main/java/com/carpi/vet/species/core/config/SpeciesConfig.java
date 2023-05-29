package com.carpi.vet.species.core.config;

import com.carpi.vet.species.domain.port.SpeciesPort;
import com.carpi.vet.species.domain.usecase.GetAllSpeciesUseCase;
import com.carpi.vet.species.domain.usecase.GetSpeciesUseCase;
import com.carpi.vet.species.domain.usecase.SaveSpeciesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeciesConfig {

    @Bean
    public SaveSpeciesUseCase saveSpeciesUseCase(SpeciesPort speciesPort)
    {
        return new SaveSpeciesUseCase(speciesPort);
    }

    @Bean
    public GetAllSpeciesUseCase getAllSpeciesUseCase(SpeciesPort speciesPort)
    {
        return new GetAllSpeciesUseCase(speciesPort);
    }

    @Bean
    public GetSpeciesUseCase getGetSpeciesUseCase(SpeciesPort speciesPort)
    {
        return new GetSpeciesUseCase(speciesPort);
    }
}
