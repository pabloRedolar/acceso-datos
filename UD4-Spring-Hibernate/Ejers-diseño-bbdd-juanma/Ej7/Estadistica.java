package org.example.Ej7;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Estadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private int minutosJugados;
    private int puntos;
    private int rebotes;
    private int asistencias;
    private int tapones;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    // Getters and setters
}
