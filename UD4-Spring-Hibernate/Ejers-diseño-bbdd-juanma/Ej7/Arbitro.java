package org.example.Ej7;

package org.example;

import jakarta.persistence.*;

@Entity
public class Arbitro extends Persona {
    private int aniosEnACB;

    @ManyToMany(mappedBy = "arbitros")
    private Set<Partido> partidos;

    // Getters and setters
}