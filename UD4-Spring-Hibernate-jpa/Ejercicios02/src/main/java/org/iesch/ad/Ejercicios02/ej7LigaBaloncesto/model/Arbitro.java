package org.iesch.ad.Ejercicios02.ej7LigaBaloncesto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Arbitro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nif;
    private String nombre;
    private String apellidos;
    private LocalDate fecha_nacimiento;

    @OneToMany(mappedBy = "arbitro1")
    private Set<Partido> partidos1 = new HashSet<>();

    @OneToMany(mappedBy = "arbitro2")
    private Set<Partido> partidos2 = new HashSet<>();

    @OneToMany(mappedBy = "arbitro3")
    private Set<Partido> partidos3 = new HashSet<>();
}
