package iesch.org.ad.Ejercicios01.model.Ej2EmpleadosOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tarjeta_acceso_id", referencedColumnName = "id")
    TarjetaAcceso tarjetaAcceso;
}
