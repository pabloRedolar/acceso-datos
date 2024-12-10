package org.example.Ej7;

package org.example;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Entrenador extends Persona {
    private int aniosExperiencia;
    private Date fechaFinContrato;

    @OneToOne(mappedBy = "entrenador")
    private Equipo equipo;

    // Getters and setters
}