package org.iesch.ad.demoFiltros_ModeloUsuario.repositories;

import org.iesch.ad.demoFiltros_ModeloUsuario.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
