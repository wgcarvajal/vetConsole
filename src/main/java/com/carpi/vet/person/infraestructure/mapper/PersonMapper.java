package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.infraestructure.data.model.PersonData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    private final UserMapper userMapper;
    private final IdentificationTypeMapper identificationTypeMapper;

    public Person toPerson(PersonData personData) {
        return new Person(
                personData.getId(),
                userMapper.toUser(personData.getUser()),
                identificationTypeMapper.toIdentificationType(personData.getIdentificationType()),
                personData.getIdentification(),
                personData.getName(),
                personData.getLastName(),
                personData.getAddress(),
                personData.getPhone());
    }

    public PersonData toPersonData(Person person) {
        return new PersonData(
                person.getId(),
                userMapper.toUserData(person.getUser()),
                identificationTypeMapper.toIdentificationTypeData(person.getIdentificationType()),
                person.getIdentification(),
                person.getName(),
                person.getLastName(),
                person.getAddress(),
                person.getPhone());
    }
}
