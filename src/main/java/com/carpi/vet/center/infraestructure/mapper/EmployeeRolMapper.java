package com.carpi.vet.center.infraestructure.mapper;

import com.carpi.vet.center.domain.model.Employee;
import com.carpi.vet.center.domain.model.EmployeeRol;
import com.carpi.vet.center.domain.model.Rol;
import com.carpi.vet.center.infraestructure.data.model.EmployeeData;
import com.carpi.vet.center.infraestructure.data.model.EmployeeRolData;
import com.carpi.vet.center.infraestructure.data.model.RolData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeRolMapper {

    private final EmployeeMapper employeeMapper;
    private final RolMapper rolMapper;

    public EmployeeRol toEmployeeRol(EmployeeRolData employeeRolData) {
        Employee employee = employeeMapper.toEmployee(employeeRolData.getEmployee());
        Rol rol = rolMapper.toRol(employeeRolData.getRol());
        return new EmployeeRol(
                employeeRolData.getId(),
                employee,
                rol);
    }

    public EmployeeRolData toEmployeeRolData(EmployeeRol employeeRol) {

        EmployeeData employeeData = employeeMapper.toEmployeeData(employeeRol.getEmployee());
        RolData rolData = rolMapper.toRolData(employeeRol.getRol());
        return new EmployeeRolData(
                employeeRol.getId(),
                employeeData,
                rolData);
    }
}
