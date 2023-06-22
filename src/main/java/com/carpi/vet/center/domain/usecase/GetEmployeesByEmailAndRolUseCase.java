package com.carpi.vet.center.domain.usecase;

import com.carpi.vet.center.domain.model.Employee;
import com.carpi.vet.center.domain.model.response.EmployeeResponse;
import com.carpi.vet.center.domain.port.CenterPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetEmployeesByEmailAndRolUseCase {
    private final CenterPort port;

    public List<EmployeeResponse> execute(String email, String rol) {
        return port.getEmployeesByEmailAndRol(email, rol);
    }
}
