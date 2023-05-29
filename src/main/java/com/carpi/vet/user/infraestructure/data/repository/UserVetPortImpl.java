package com.carpi.vet.user.infraestructure.data.repository;

import com.carpi.vet.user.domain.model.UserVet;
import com.carpi.vet.user.domain.port.UserVetPort;
import com.carpi.vet.user.infraestructure.data.model.UserVetData;
import com.carpi.vet.user.infraestructure.mapper.MapperUserVet;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserVetPortImpl implements UserVetPort {

    private final MapperUserVet mapper;
    private final UserVetRepository repository;

    @Override
    public UserVet save(UserVet userVet) {
        return mapper.toUserVet(repository.save(mapper.toUserVetData(userVet)));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserVet findById(Long id) {
        return mapper.toUserVet(repository.findById(id).get());
    }

    @Override
    public UserVet findByEmail(String email) {
        Optional<UserVetData> result = repository.findOneByEmail(email);
        return result.map(mapper::toUserVet).orElse(null);
    }

    @Override
    public List<UserVet> getAll() {
        List<UserVet> result = new ArrayList<>();
        val iterable = repository.findAll();
        for (UserVetData userVetData : iterable) {
            result.add(mapper.toUserVet(userVetData));
        }
        return result;
    }
}
