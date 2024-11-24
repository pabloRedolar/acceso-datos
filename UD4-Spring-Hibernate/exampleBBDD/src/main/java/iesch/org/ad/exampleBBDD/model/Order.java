package iesch.org.ad.exampleBBDD.model;

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
