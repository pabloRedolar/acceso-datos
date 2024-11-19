package iesch.org.ad.exampleBBDD.model.bidir_manyToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToMany
    @JoinTable (name = "estudiante_asignaturas", joinColumns = @JoinColumn (name = "id_estudiante"), inverseJoinColumns = @JoinColumn (name = "id_asignatura"))

    private List<Asignatura> asignaturas;

}
