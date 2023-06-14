package com.carpi.vet.security.infraestructure.entrypoint;

import com.carpi.vet.security.domain.port.ProvidersPort;
import com.carpi.vet.security.infraestructure.entrypoint.model.BasicAuthCredentials;
import com.carpi.vet.security.infraestructure.entrypoint.model.SocialAuthCredentials;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;

@AllArgsConstructor
public class CustomProvider implements AuthenticationProvider {

    private final Map<String, ProvidersPort> providers;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object authCredentials = authentication.getPrincipal();
        System.out.println(authCredentials.toString());
        if (authCredentials instanceof BasicAuthCredentials) {
            return providers.get("Basic").execute(authCredentials);
        } else {
            ProvidersPort providersPort = providers.get(((SocialAuthCredentials) authCredentials).getProvider());
            if(providersPort!=null)
            {
                return providersPort.execute(authCredentials);
            }
            throw new UsernameNotFoundException("unsupported provider");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
