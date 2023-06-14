package com.carpi.vet.security.infraestructure.data;

import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.port.PersonPort;
import com.carpi.vet.security.infraestructure.entrypoint.model.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.carpi.vet.person.utils.PersonConstants.AuthErrors.EMAIL_IS_NOT_REGISTERED;

@Service
@RequiredArgsConstructor
@Qualifier("basicUserDetailService")
public class BasicUserDetailService implements UserDetailsService {

    private final PersonPort personPort;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = personPort.getByEmail(email);
        if (person != null) {
            return new UserDetailsImpl(person);
        } else {
            throw new UsernameNotFoundException(EMAIL_IS_NOT_REGISTERED);
        }
    }
}
