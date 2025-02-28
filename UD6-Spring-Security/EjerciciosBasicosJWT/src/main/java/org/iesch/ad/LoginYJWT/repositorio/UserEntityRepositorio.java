package org.iesch.ad.LoginYJWT.repositorio;

import org.iesch.ad.LoginYJWT.modelo.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepositorio extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
