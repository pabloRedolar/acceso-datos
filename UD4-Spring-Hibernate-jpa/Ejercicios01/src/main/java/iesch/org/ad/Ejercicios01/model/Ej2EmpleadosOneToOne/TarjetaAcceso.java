package iesch.org.ad.Ejercicios01.model.Ej2EmpleadosOneToOne;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TarjetaAcceso {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;
    long codigo_acceso;
    LocalDate fecha_expiracion;

}
