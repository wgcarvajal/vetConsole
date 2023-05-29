package com.carpi.vet.species.domain.usecase;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.domain.port.SpeciesPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveSpeciesUseCase {

    private final SpeciesPort speciesPort;

    public Species save(Species species) {
        return speciesPort.save(species);
    }
}
