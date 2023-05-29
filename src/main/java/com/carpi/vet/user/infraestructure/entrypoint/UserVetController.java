package com.carpi.vet.user.infraestructure.entrypoint;

import com.carpi.vet.user.domain.model.UserVet;
import com.carpi.vet.user.domain.usecase.GetUserByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserVetController {
    private final GetUserByEmailUseCase getUserByEmailUseCase;

    @GetMapping("/{email}")
    public UserVet getUserByEmailUseCase(@PathVariable String email) {
        return getUserByEmailUseCase.execute(email);
    }
}
