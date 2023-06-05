package com.carpi.vet.person.infraestructure.mapper;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.infraestructure.data.model.IdentificationTypeData;
import org.springframework.stereotype.Component;

@Component
public class IdentificationTypeMapper {

    public IdentificationType toIdentificationType(IdentificationTypeData identificationTypeData) {
        return new IdentificationType(identificationTypeData.getId(), identificationTypeData.getName());
    }

    public IdentificationTypeData toIdentificationTypeData(IdentificationType identificationType) {
        return new IdentificationTypeData(identificationType.getId(), identificationType.getName());
    }
}
