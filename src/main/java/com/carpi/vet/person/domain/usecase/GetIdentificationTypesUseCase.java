package com.carpi.vet.person.domain.usecase;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.port.IdentificationTypePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetIdentificationTypesUseCase {

    private final IdentificationTypePort identificationTypePort;

    public List<IdentificationType> getIdentificationTypes()
    {
        return identificationTypePort.getAll();
    }
}
