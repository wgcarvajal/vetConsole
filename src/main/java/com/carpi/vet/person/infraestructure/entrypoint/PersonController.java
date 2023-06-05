package com.carpi.vet.person.infraestructure.entrypoint;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.usecase.GetIdentificationTypesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
class PersonController {
    private final GetIdentificationTypesUseCase getIdentificationTypesUseCase;

    @GetMapping("")
    public List<IdentificationType> getIdentificationTypes()
    {
        return  getIdentificationTypesUseCase.getIdentificationTypes();
    }
}