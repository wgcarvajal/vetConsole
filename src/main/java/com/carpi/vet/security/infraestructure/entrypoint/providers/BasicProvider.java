package com.carpi.vet.security.infraestructure.entrypoint.providers;

import com.carpi.vet.security.domain.port.ProvidersPort;
import com.carpi.vet.security.domain.usecase.LoadUserByUsernameUseCase;
import com.carpi.vet.security.infraestructure.entrypoint.model.BasicAuthCredentials;
import com.carpi.vet.security.infraestructure.entrypoint.model.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.carpi.vet.person.utils.PersonConstants.AuthErrors.BAD_CREDENTIALS;
import static com.carpi.vet.person.utils.PersonConstants.AuthErrors.CAN_NOT_LOGIN_WITH_EMAIL;
import static com.carpi.vet.person.utils.PersonConstants.User.AUTH_BASIC;

@AllArgsConstructor
@Service
@Qualifier("basicProvider")
public class BasicProvider implements ProvidersPort {

    private final LoadUserByUsernameUseCase loadUserByUsernameUseCase;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication execute(Object authCredentials) throws AuthenticationException {
        String email = ((BasicAuthCredentials) authCredentials).getEmail();
        String password = ((BasicAuthCredentials) authCredentials).getPassword();

        System.out.println("email:" + email + " password:" + password);

        UserDetailsImpl user = (UserDetailsImpl) loadUserByUsernameUseCase.execute(email);
        if (user.getUserType().equals(AUTH_BASIC)) {
            if (!passwordEncoder.matches(password, user.getPassword())) {
                System.out.println(BAD_CREDENTIALS);
                throw new UsernameNotFoundException(BAD_CREDENTIALS);
            }
        } else {
            throw new UsernameNotFoundException(CAN_NOT_LOGIN_WITH_EMAIL);
        }
        return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
    }
}
