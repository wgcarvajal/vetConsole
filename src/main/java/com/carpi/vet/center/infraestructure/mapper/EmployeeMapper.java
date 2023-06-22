package com.carpi.vet.center.infraestructure.mapper;

import com.carpi.vet.center.domain.model.Center;
import com.carpi.vet.center.domain.model.Employee;
import com.carpi.vet.center.domain.model.response.CenterResponse;
import com.carpi.vet.center.domain.model.response.EmployeeResponse;
import com.carpi.vet.center.infraestructure.data.model.CenterData;
import com.carpi.vet.center.infraestructure.data.model.EmployeeData;
import com.carpi.vet.center.infraestructure.data.model.EmployeeRolData;
import com.carpi.vet.person.domain.model.Person;
import com.carpi.vet.person.infraestructure.data.model.PersonData;
import com.carpi.vet.person.infraestructure.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final PersonMapper personMapper;
    private final CenterMapper centerMapper;
    private final RolMapper rolMapper;

    public Employee toEmployee(EmployeeData employeeData) {

        Person person = personMapper.toPerson(employeeData.getPerson());
        Center center = centerMapper.toCenter(employeeData.getCenter());
        return new Employee(
                employeeData.getId(),
                person,
                center,
                employeeData.getInitialDate(),
                employeeData.getFinalDate());
    }

    public EmployeeData toEmployeeData(Employee employee) {

        PersonData person = personMapper.toPersonData(employee.getPerson());
        CenterData center = centerMapper.toCenterData(employee.getCenter());
        return new EmployeeData(
                employee.getId(),
                person,
                center,
                employee.getInitialDate(),
                employee.getFinalDate(),
                null);
    }

    public EmployeeResponse toEmployeeResponse(EmployeeData employeeData) {

        CenterResponse center = centerMapper.toCenterResponse(employeeData.getCenter());

        List<EmployeeRolData> employeeRolDataList = employeeData.getRoles();
        List<String> roles = null;
        if (employeeRolDataList != null) {
            roles = new ArrayList<>();
            for (EmployeeRolData employeeRolData : employeeRolDataList) {
                String rolName = rolMapper.toRolName(employeeRolData.getRol());
                roles.add(rolName);
            }
        }

        return new EmployeeResponse(
                employeeData.getId(),
                center, roles
        );
    }
}
