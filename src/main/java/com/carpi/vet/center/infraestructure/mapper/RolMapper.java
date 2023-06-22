package com.carpi.vet.center.infraestructure.mapper;

import com.carpi.vet.center.domain.model.Rol;
import com.carpi.vet.center.infraestructure.data.model.RolData;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public Rol toRol(RolData rolData) {
        return new Rol(
                rolData.getId(),
                rolData.getName());
    }

    public RolData toRolData(Rol rol) {
        return new RolData(
                rol.getId(),
                rol.getName());
    }

    public String toRolName(RolData rol)
    {
        return rol.getName();
    }
}
