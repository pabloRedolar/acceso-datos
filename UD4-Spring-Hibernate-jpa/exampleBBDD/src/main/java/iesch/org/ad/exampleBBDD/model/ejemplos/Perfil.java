package iesch.org.ad.exampleBBDD.model.ejemplos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Perfil {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //autoincrementa (genera los ids)
    // en oracle y postgres se usa SEQUENCE
    Long id;
    String detalles;

//    @OneToOne
//    Usuario usuario;
//

}
