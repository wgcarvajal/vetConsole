package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.infraestructure.data.model.IdentificationTypeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeData,Integer> {
}
