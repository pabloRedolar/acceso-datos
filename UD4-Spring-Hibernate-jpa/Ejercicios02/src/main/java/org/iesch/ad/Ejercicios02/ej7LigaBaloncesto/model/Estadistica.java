package org.iesch.ad.Ejercicios02.ej7LigaBaloncesto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fecha_partido = LocalDate.now();
    private int puntos;


    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;
}
