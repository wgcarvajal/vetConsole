package com.carpi.vet.center.domain.port;

import com.carpi.vet.center.domain.model.Employee;
import com.carpi.vet.center.domain.model.response.EmployeeResponse;

import java.util.List;

public interface CenterPort {
    List<EmployeeResponse> getEmployeesByEmailAndRol(String email, String rol);
}
