package iesch.org.ad.exampleBBDD.model.ejemplos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;
    String nombre;

}
