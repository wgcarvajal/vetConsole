package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.port.IdentificationTypePort;
import com.carpi.vet.person.infraestructure.data.model.IdentificationTypeData;
import com.carpi.vet.person.infraestructure.mapper.IdentificationTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class IdentificationTypePortImpl implements IdentificationTypePort {

    private final IdentificationTypeRepository repository;
    private final IdentificationTypeMapper mapper;
    @Override
    public List<IdentificationType> getAll() {
        List<IdentificationType> result = new ArrayList<>();
        val iterable = repository.findAll();
        for (IdentificationTypeData identificationTypeData : iterable) {
            result.add(mapper.toIdentificationType(identificationTypeData));
        }
        return result;
    }
}
