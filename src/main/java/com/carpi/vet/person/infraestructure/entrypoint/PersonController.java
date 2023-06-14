package com.carpi.vet.person.infraestructure.entrypoint;

import com.carpi.vet.person.domain.model.IdentificationType;
import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.domain.usecase.GetIdentificationTypesUseCase;
import com.carpi.vet.person.domain.usecase.RegisterUserUseCase;
import com.carpi.vet.person.infraestructure.entrypoint.model.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
class PersonController {
    private final GetIdentificationTypesUseCase getIdentificationTypesUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    @GetMapping("")
    public List<IdentificationType> getIdentificationTypes() {
        return getIdentificationTypesUseCase.getIdentificationTypes();
    }

    @PostMapping("/register")
    public Person registerUser(@RequestBody RegisterUserRequest userRequest){
        System.out.println(userRequest.toString());

        Person person = registerUserUseCase.execute(
                userRequest.getEmail(),
                userRequest.getName(),
                userRequest.getLastName(),
                userRequest.getPassword(),
                true);
        return person;
    }
}