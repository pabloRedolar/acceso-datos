package iesch.org.ad.exampleBBDD.model.bidir_oneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    @OneToOne
    @JoinColumn (name = "ciudadano_id")
    private Ciudadano ciudadano;
}
