package com.carpi.vet.person.domain.port;

import com.carpi.vet.person.domain.model.Person;

public interface PersonPort {
    Person getByEmail(String email);
}
