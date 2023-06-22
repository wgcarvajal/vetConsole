package com.carpi.vet.center.infraestructure.data.repository;

import com.carpi.vet.center.infraestructure.data.model.EmployeeData;
import com.carpi.vet.center.infraestructure.data.model.EmployeeRolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRolRepository extends JpaRepository<EmployeeRolData, Long> {

    @Query(value = "SELECT e FROM EmployeeRolData er INNER JOIN er.employee e INNER JOIN er.rol r Where e.person.user.email =:email And r.name = :rol and e.finalDate IS NULL")
    List<EmployeeData> findEmployeesByEmailAndRol(String email, String rol);
}
