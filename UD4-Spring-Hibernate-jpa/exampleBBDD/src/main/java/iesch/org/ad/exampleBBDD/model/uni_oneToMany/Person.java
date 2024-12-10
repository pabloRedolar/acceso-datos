package iesch.org.ad.exampleBBDD.model.uni_oneToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Person {
    // Una persona puede tener muchas direcciones per una direccion no va a tener referencia a la persona
    // Uno a muchos

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany
    @JoinColumn (name = "person_id")
    private List<Direccion> direcciones;

}
