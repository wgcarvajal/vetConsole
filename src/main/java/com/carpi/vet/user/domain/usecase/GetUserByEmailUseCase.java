package com.carpi.vet.user.domain.usecase;

import com.carpi.vet.user.domain.model.UserVet;
import com.carpi.vet.user.domain.port.UserVetPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserByEmailUseCase {

    private final UserVetPort userVetPort;

    public UserVet execute(String email){
        return userVetPort.findByEmail(email);
    }
}
