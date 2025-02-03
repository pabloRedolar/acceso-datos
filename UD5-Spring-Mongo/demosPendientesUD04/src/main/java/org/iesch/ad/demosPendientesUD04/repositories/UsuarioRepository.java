package org.iesch.ad.demosPendientesUD04.repositories;

import org.iesch.ad.demosPendientesUD04.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
