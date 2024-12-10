package iesch.org.ad.Ejercicios01.model.Ej3TiendaOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DireccionEnvio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    String calle;
    String ciudad;
    int codigo_postal;
    String pais;

    @OneToOne
    Pedido pedido;
}
