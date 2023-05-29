package com.carpi.vet.user.infraestructure.data.repository;

import com.carpi.vet.user.infraestructure.data.model.UserVetData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserVetRepository extends JpaRepository<UserVetData, Long> {

    Optional<UserVetData> findOneByEmail(String email);
}
