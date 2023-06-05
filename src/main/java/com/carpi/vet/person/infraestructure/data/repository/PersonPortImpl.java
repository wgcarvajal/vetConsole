package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import com.carpi.vet.person.infraestructure.data.model.PersonData;
import com.carpi.vet.person.infraestructure.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonPortImpl implements PersonPort {
    private final PersonRepository repository;
    private final PersonMapper personMapper;
    @Override
    public Person getByEmail(String email) {
        PersonData result = repository.findByEmail(email);
        if(result!=null)
        {
            return personMapper.toPerson(result);
        }
        return null;
    }
}
