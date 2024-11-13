package iesch.org.ad.exampleBBDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private long id;

    private String nombre;


    private String apellido1;
    private String apellido2;
    private String dni;
}
