package iesch.org.ad.Ejercicios01.model.Ej1BibliotecaOneToOne;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Perfil {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    String foto_perfil;
    String descripcion;
    LocalDate fecha_nacimiento;


}
