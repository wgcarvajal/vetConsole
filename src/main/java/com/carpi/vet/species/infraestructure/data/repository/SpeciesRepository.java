package com.carpi.vet.species.infraestructure.data.repository;

import com.carpi.vet.species.infraestructure.data.model.SpeciesData;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<SpeciesData,Integer> {
}
