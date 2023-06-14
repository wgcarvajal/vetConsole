package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.model.User_;
import com.carpi.vet.person.infraestructure.data.model.IdentificationTypeData;
import com.carpi.vet.person.infraestructure.data.model.PersonData;
import com.carpi.vet.person.infraestructure.data.model.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {
    private final UserMapper userMapper;
    private final IdentificationTypeMapper identificationTypeMapper;

    public Person toPerson(PersonData personData) {
        IdentificationType identificationType = null;
        User_ user = null;
        if (personData.getUser() != null) {
            user = userMapper.toUser(personData.getUser());
        }
        if (personData.getIdentificationType() != null) {
            identificationType = identificationTypeMapper.toIdentificationType(personData.getIdentificationType());
        }
        return new Person(
                personData.getId(),
                user,
                identificationType,
                personData.getIdentification(),
                personData.getName(),
                personData.getLastName(),
                personData.getAddress(),
                personData.getPhone());
    }

    public PersonData toPersonData(Person person) {
        IdentificationTypeData identificationType = null;
        UserData user = null;
        if (person.getUser() != null) {
            user = userMapper.toUserData(person.getUser());
        }
        if (person.getIdentificationType() != null) {
            identificationType = identificationTypeMapper.toIdentificationTypeData(person.getIdentificationType());
        }
        return new PersonData(
                person.getId(),
                user,
                identificationType,
                person.getIdentification(),
                person.getName(),
                person.getLastName(),
                person.getAddress(),
                person.getPhone());
    }
}
