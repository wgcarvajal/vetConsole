package com.carpi.vet.species.domain.usecase;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.domain.port.SpeciesPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSpeciesUseCase {
    private final SpeciesPort speciesPort;

    public Species get(Integer id)
    {
        return speciesPort.findById(id);
    }
}
