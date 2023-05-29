package com.carpi.vet.user.infraestructure.mapper;

import com.carpi.vet.user.domain.model.UserVet;
import com.carpi.vet.user.infraestructure.data.model.UserVetData;
import org.springframework.stereotype.Component;

@Component
public class MapperUserVet {

    public UserVet toUserVet(UserVetData userVetData) {
        return new UserVet(userVetData.getId(), userVetData.getEmail(), userVetData.getPassword(),userVetData.getName());
    }

    public UserVetData toUserVetData(UserVet userVet) {
        return new UserVetData(userVet.getId(), userVet.getEmail(), userVet.getPassword(),userVet.getName());
    }
}
