package com.carpi.vet.center.infraestructure.data.repository;

import com.carpi.vet.center.domain.model.response.EmployeeResponse;
import com.carpi.vet.center.domain.port.CenterPort;
import com.carpi.vet.center.infraestructure.data.model.EmployeeData;
import com.carpi.vet.center.infraestructure.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CenterPortImpl implements CenterPort {

    private final EmployeeRolRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeResponse> getEmployeesByEmailAndRol(String email, String rol) {
        List<EmployeeData> employeeDataList = repository.findEmployeesByEmailAndRol(email, rol);
        ArrayList<EmployeeResponse> employees = new ArrayList<>();
        if (employeeDataList != null) {
            for (EmployeeData e : employeeDataList) {
                employees.add(mapper.toEmployeeResponse(e));
            }
            return employees;
        }
        return null;
    }
}
