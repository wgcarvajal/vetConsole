package com.carpi.vet.species.infraestructure.data.repository;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.domain.port.SpeciesPort;
import com.carpi.vet.species.infraestructure.data.model.SpeciesData;
import com.carpi.vet.species.infraestructure.mapper.MapperSpecies;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SpeciesPortImpl implements SpeciesPort {

    private final MapperSpecies mapper;
    private final SpeciesRepository repository;
    @Override
    public Species save(Species species) {
        return mapper.toSpecies(repository.save(mapper.toSpeciesData(species)));
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Species findById(Integer id) {
        return mapper.toSpecies(repository.findById(id).get());
    }

    @Override
    public List<Species> getAll() {
        List<Species> result = new ArrayList<>();
        val iterable = repository.findAll();
        for (SpeciesData speciesData : iterable) {
            result.add(mapper.toSpecies(speciesData));
        }
        return result;
    }
}
