package iesch.org.ad.exampleBBDD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    Long id;

    String first_name;
    String last_name;
    String email;
    String gender;
    String ip_address;
    String dni;

//    @OneToOne
//    Perfil perfil;

}
