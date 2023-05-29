package com.carpi.vet.species.domain.port;

import com.carpi.vet.species.domain.model.Species;

import java.util.List;

public interface SpeciesPort {
    Species save(Species species);
    void delete(Integer id);
    Species findById(Integer id);
    List<Species> getAll();
}
