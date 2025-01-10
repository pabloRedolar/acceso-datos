package org.iesch.ad.Ej2.repositories;

import org.iesch.ad.Ej2.models.Tenista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface TenistaRepository extends JpaRepository<Tenista, Long> {

//    Object saveTenistaById(Long id, Tenista tenista);

}
