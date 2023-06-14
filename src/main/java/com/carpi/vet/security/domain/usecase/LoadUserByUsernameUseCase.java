package com.carpi.vet.security.domain.usecase;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class LoadUserByUsernameUseCase {
    private final UserDetailsService userDetailsService;

    public UserDetails execute(String email) throws UsernameNotFoundException
    {
        return userDetailsService.loadUserByUsername(email);
    }
}
