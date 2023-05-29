package com.carpi.vet.species.infraestructure.entrypoint;

import com.carpi.vet.species.domain.model.Species;
import com.carpi.vet.species.domain.usecase.GetAllSpeciesUseCase;
import com.carpi.vet.species.domain.usecase.GetSpeciesUseCase;
import com.carpi.vet.species.domain.usecase.SaveSpeciesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/species")
@RequiredArgsConstructor
public class SpeciesController {
    private final SaveSpeciesUseCase saveSpeciesUseCase;
    private final GetAllSpeciesUseCase getAllSpeciesUseCase;
    private final GetSpeciesUseCase getSpeciesUseCase;

    @GetMapping("")
    public List<Species> getSpecies()
    {
        return  getAllSpeciesUseCase.getAll();
    }

    @GetMapping("/{id}")
    public Species getSpecies(@PathVariable Integer id)
    {
        return  getSpeciesUseCase.get(id);
    }

}
