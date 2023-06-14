package com.carpi.vet.security.domain.usecase;

import com.carpi.vet.security.domain.port.SocialDetailService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class LoadUserByEmailOrRegisterUserUseCase {
    private final SocialDetailService socialDetailsService;

    public UserDetails execute(String email, String name, String lastName) throws UsernameNotFoundException {
        return socialDetailsService.loadUserByEmailOrRegisterUser(email,name,lastName);
    }
}
