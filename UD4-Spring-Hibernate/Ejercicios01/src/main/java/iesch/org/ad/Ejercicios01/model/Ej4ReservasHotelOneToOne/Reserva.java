package iesch.org.ad.Ejercicios01.model.Ej4ReservasHotelOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne //(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_habitacion", referencedColumnName = "id")
    Habitacion habitacion;


}
