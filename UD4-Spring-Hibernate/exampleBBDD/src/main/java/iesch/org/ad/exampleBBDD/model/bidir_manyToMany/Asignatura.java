package iesch.org.ad.exampleBBDD.model.bidir_manyToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToMany (mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;

}
