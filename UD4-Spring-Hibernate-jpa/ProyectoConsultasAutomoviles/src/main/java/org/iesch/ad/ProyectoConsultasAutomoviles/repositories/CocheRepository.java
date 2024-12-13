package org.iesch.ad.ProyectoConsultasAutomoviles.repositories;

import org.iesch.ad.ProyectoConsultasAutomoviles.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface CocheRepository extends JpaRepository<Coche, String> {
    @Query("SELECT c FROM Coche c where size(c.revisiones) = (SELECT min(size(co.revisiones)) FROM Coche co)")
    List<Object> cochesConMenosRevisiones();

//    @Query("SELECT r.coche.matricula, count(r) FROM Revision r GROUP BY r.coche")
    @Query("SELECT c.matricula, size(c.revisiones) FROM Coche c")
    List<Object> cochesMatriculaRevisiones();


}
