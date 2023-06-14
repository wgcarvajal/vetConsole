package com.carpi.vet.security.infraestructure.entrypoint.providers;

import com.carpi.vet.security.domain.port.ProvidersPort;
import com.carpi.vet.security.domain.usecase.LoadUserByEmailOrRegisterUserUseCase;
import com.carpi.vet.security.infraestructure.entrypoint.model.SocialAuthCredentials;
import com.carpi.vet.security.infraestructure.entrypoint.model.UserDetailsImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import static com.carpi.vet.person.utils.PersonConstants.User.AUTH_SOCIAL;
import static com.carpi.vet.utils.ErrorConstants.SocialError.TOKEN_INVALID;

@AllArgsConstructor
@Service
@Qualifier("googleProvider")
public class GoogleProvider implements ProvidersPort {
    private final LoadUserByEmailOrRegisterUserUseCase loadUserByEmailOrRegisterUserUseCase;

    @Override
    public Authentication execute(Object authCredentials)throws AuthenticationException {
        String token = ((SocialAuthCredentials)authCredentials).getSocialToken();
        if (token!=null && !token.isEmpty()) {
            NetHttpTransport transport = new NetHttpTransport();
            JsonFactory jsonFactory = new GsonFactory();

            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                    .setAudience(Collections.singletonList("987785305857-mq7o4d7l3pt2ispufecqt09fe271p4c1.apps.googleusercontent.com"))
                    .build();
            GoogleIdToken idToken = null;
            try {
                idToken = verifier.verify(token);
                if (idToken != null) {
                    GoogleIdToken.Payload payload = idToken.getPayload();
                    String email = payload.getEmail();
                    String name = (String) payload.get("given_name");
                    String lastName = (String) payload.get("family_name");
                    UserDetailsImpl user = (UserDetailsImpl) loadUserByEmailOrRegisterUserUseCase.execute(email, name, lastName);
                    if (user.getUserType().equals(AUTH_SOCIAL)) {
                        return new UsernamePasswordAuthenticationToken(user, "", Collections.emptyList());
                    } else {
                        throw new UsernameNotFoundException("user does not have social login");
                    }
                } else {
                    throw new UsernameNotFoundException(TOKEN_INVALID);
                }
            } catch (GeneralSecurityException | IOException e) {
                throw new UsernameNotFoundException(e.getMessage());
            }
            catch (IllegalArgumentException e)
            {
                throw new UsernameNotFoundException(TOKEN_INVALID);
            }
        } else {
            throw new UsernameNotFoundException(TOKEN_INVALID);
        }
    }
}
