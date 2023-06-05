package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.infraestructure.data.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonData, Long> {

    @Query(value = "SELECT p FROM PersonData p WHERE p.user.email = :email")
    PersonData findByEmail(String email);

}
