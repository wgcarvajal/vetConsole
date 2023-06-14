package com.carpi.vet.security.infraestructure.data;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import com.carpi.vet.security.domain.port.SocialDetailService;
import com.carpi.vet.security.infraestructure.entrypoint.model.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("socialUserDetailService")
public class SocialUserDetailService extends SocialDetailService {

    private final PersonPort personPort;
    @Override
    public UserDetails loadUserByEmailOrRegisterUser(String email, String name, String lastName) throws UsernameNotFoundException {
        Person person = personPort.getByEmail(email);
        if (person != null) {
            return new UserDetailsImpl(person);
        } else {
            return new UserDetailsImpl(personPort.save(email,null,name,lastName,false));
        }
    }
}
