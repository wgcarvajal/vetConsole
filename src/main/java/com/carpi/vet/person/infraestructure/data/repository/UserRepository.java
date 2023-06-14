package com.carpi.vet.person.infraestructure.data.repository;

import com.carpi.vet.person.infraestructure.data.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Long>{
}
