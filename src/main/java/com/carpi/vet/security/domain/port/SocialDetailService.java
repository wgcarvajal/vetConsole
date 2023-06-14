package com.carpi.vet.security.domain.port;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class SocialDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public abstract UserDetails loadUserByEmailOrRegisterUser(String email, String name, String lastName) throws UsernameNotFoundException;
}
