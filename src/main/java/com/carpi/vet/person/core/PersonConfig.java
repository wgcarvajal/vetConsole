package com.carpi.vet.person.core;

import com.carpi.vet.person.domain.port.IdentificationTypePort;
import com.carpi.vet.person.domain.port.PersonPort;
import com.carpi.vet.person.domain.usecase.GetIdentificationTypesUseCase;
import com.carpi.vet.person.domain.usecase.GetPersonByEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {
    @Bean
    public GetIdentificationTypesUseCase identificationTypesUseCase(IdentificationTypePort identificationTypePort){
        return new GetIdentificationTypesUseCase(identificationTypePort);
    }

    @Bean
    public GetPersonByEmailUseCase getPersonByEmailUseCase(PersonPort personPort){
        return new GetPersonByEmailUseCase(personPort);
    }
}
