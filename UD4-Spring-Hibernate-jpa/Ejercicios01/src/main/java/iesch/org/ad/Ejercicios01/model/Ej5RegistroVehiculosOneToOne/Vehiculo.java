package iesch.org.ad.Ejercicios01.model.Ej5RegistroVehiculosOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne //(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_registro", referencedColumnName = "id")
    RegistroVehiculo registroVehiculo;


}
