package com.carpi.vet.species.infraestructure.mapper;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.infraestructure.data.model.SpeciesData;
import org.springframework.stereotype.Component;

@Component
public class MapperSpecies {

    public Species toSpecies(SpeciesData speciesData) {
        return new Species(speciesData.getId(), speciesData.getName(), speciesData.getState());
    }

    public SpeciesData toSpeciesData(Species species) {
        return new SpeciesData(species.getId(), species.getName(), species.getState());
    }
}
