package iesch.org.ad.exampleBBDD.model.bidir_oneToMany_manyToOne;

import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn (name = "autor_id")
    private Autor autor;
}
