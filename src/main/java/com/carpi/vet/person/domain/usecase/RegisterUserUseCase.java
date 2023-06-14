package com.carpi.vet.person.domain.usecase;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterUserUseCase {
    private final PersonPort personPort;

    public Person execute(String email, String name, String lastName, String password,boolean basic)
    {
        return personPort.save(email,password,name,lastName,basic);
    }
}
