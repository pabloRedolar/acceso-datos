package org.example.Ej7;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nombreAbreviado;
    private Date fechaFundacion;
    private int titulos;

    @OneToOne
    @JoinColumn(name = "pabellon_id")
    private Pabellon pabellon;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadores;

    @OneToMany(mappedBy = "equipoLocal")
    private Set<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisitante")
    private Set<Partido> partidosVisitante;

    // Getters and setters
}