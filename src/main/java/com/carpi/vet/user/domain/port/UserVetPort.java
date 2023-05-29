package com.carpi.vet.user.domain.port;

import com.carpi.vet.user.domain.model.UserVet;

import java.util.List;

public interface UserVetPort {

    UserVet save(UserVet userVet);

    void delete(Long id);

    UserVet findById(Long id);

    UserVet findByEmail(String email);

    List<UserVet> getAll();
}
