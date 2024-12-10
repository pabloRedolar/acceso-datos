package iesch.org.ad.Ejercicios01.model.Ej4ReservasHotelOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


}
