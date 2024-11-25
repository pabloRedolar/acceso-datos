package iesch.org.ad.Ejercicios01.model.Ej1BibliotecaOneToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn (name = "id", referencedColumnName = "id")
            Perfil perfil;

}
