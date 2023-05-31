package com.carpi.vet.security;

import com.carpi.vet.user.domain.model.UserVet;
import com.carpi.vet.user.domain.port.UserVetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserVetPort userVetPort;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserVet userVet = userVetPort.findByEmail(email);
        if (userVet != null) {
            return new UserDetailsImpl(userVet);
        } else {
            throw new UsernameNotFoundException("the user with email "+ email+" does not exist");
        }
    }
}
