package iesch.org.ad.exampleBBDD.model.bidir_oneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ciudadano {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToOne (mappedBy = "ciudadano")
    private Pasaporte pasaporte;
}
