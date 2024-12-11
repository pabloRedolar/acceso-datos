package org.iesch.ad.Ejercicios02.ej7LigaBaloncesto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String nombre_abreviado;

    @OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadores = new HashSet<>();

    @OneToOne
    private Entrenador entrenador;


}
