package org.iesch.ad.EjerciciosBasicosSecurity.repositories;

import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
