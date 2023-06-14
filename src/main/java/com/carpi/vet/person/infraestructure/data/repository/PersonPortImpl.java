package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.model.UserType;
import com.carpi.vet.person.domain.model.User_;
import com.carpi.vet.person.domain.port.PersonPort;
import com.carpi.vet.person.infraestructure.data.model.PersonData;
import com.carpi.vet.person.infraestructure.data.model.UserData;
import com.carpi.vet.person.infraestructure.data.model.UserTypeData;
import com.carpi.vet.person.infraestructure.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PersonPortImpl implements PersonPort {
    private final PersonRepository repository;
    private final UserRepository userRepository;
    private final PersonMapper personMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Person getByEmail(String email) {
        PersonData result = repository.findByEmail(email);
        if(result!=null)
        {
            return personMapper.toPerson(result);
        }
        return null;
    }

    @Override
    @Transactional
    public Person save(String email,String password,String name, String lastName,boolean basic){
        UserTypeData userTypeData;
        if(basic)
        {
            userTypeData = new UserTypeData(1,"basic");
        }
        else{
            userTypeData = new UserTypeData(2,"social");
        }

        if(password!=null)
        {
            password = passwordEncoder.encode(password);
        }

        UserData userData = new UserData(null,userTypeData,email,password);
        userRepository.save(userData);
        PersonData personData = new PersonData(
                null,
                userData,
                null,
                null,
                name,
                lastName,
                null,
                null);
        repository.save(personData);
        return personMapper.toPerson(personData);
    }


}
