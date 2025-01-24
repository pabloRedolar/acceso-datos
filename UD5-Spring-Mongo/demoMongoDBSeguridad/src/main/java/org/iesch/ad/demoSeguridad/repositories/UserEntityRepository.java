package org.iesch.ad.demoSeguridad.repositories;

import org.iesch.ad.demoSeguridad.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {



}
