package com.carpi.vet.person.domain.port;

import com.carpi.vet.person.domain.model.IdentificationType;

import java.util.List;

public interface IdentificationTypePort {
    List<IdentificationType> getAll();
}
