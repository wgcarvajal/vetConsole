package com.carpi.vet.person.domain.usecase;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPersonByEmailUseCase {
    private final PersonPort port;

    public Person execute(String email)
    {
        return port.getByEmail(email);
    }
}
