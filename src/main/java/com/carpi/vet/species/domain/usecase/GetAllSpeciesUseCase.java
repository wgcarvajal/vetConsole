package com.carpi.vet.species.domain.usecase;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.domain.port.SpeciesPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllSpeciesUseCase {

    private final SpeciesPort speciesPort;

    public List<Species> getAll()
    {
        return speciesPort.getAll();
    }
}
