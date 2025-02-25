package org.iesch.ad.EjerciciosBasicosSecurity.repositories;

import org.iesch.ad.EjerciciosBasicosSecurity.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
