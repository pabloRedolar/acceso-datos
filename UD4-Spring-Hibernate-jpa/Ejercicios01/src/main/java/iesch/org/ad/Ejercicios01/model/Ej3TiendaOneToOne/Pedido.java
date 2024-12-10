package iesch.org.ad.Ejercicios01.model.Ej3TiendaOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "direccion_envio_id", referencedColumnName = "id")
    DireccionEnvio direccionEnvio;

}
