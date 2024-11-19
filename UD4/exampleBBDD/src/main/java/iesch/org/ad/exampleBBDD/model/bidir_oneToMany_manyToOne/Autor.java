package iesch.org.ad.exampleBBDD.model.bidir_oneToMany_manyToOne;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    //Un autor puede tener muchos libros
    @OneToMany (mappedBy = "autor")
    private List<Libro> libros;

}
