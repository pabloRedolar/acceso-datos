package iesch.org.ad.exampleBBDD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

}
