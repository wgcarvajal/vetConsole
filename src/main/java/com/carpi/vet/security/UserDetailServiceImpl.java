package com.carpi.vet.security;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final PersonPort personPort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personPort.getByEmail(email);
        if (person != null) {
            return new UserDetailsImpl(person);
        } else {
            throw new UsernameNotFoundException("the user with email "+ email+" does not exist");
        }
    }
}
