package com.carpi.vet.center.infraestructure.entrypoint;

import com.carpi.vet.center.domain.model.Employee;
import com.carpi.vet.center.domain.usecase.GetEmployeesByEmailAndRolUseCase;
import com.carpi.vet.center.infraestructure.entrypoint.model.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/center")
@RequiredArgsConstructor
public class CenterController {

    private final GetEmployeesByEmailAndRolUseCase getEmployeesByEmailAndRolUseCase;

    @PostMapping("/employees")
    public List<Employee> getEmployees(@RequestBody EmployeeRequest employeeRequest) {
        System.out.println(employeeRequest.toString());

        List employees = getEmployeesByEmailAndRolUseCase.execute(
                employeeRequest.getEmail(),
                employeeRequest.getRol());
        return employees;
    }
}
