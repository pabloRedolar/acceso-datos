package iesch.org.ad.Ejercicios01.model.Ej5RegistroVehiculosOneToOne;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class RegistroVehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long numero_registro;
    LocalDate fecha_expedicion;
    LocalDate fecha_vencimiento;





}
