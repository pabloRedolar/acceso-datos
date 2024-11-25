package iesch.org.ad.exampleBBDD.model.ejemplos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY )
    long id;
    String contenido;

    @ManyToOne
    Cliente cliente;

}
