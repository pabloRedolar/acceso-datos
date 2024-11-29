package org.example.Ej7;

package org.example;

import jakarta.persistence.*;

@Entity
public class Jugador extends Persona {
    private double peso;
    private double altura;
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private Set<Estadistica> estadisticas;

    // Getters and setters
}
