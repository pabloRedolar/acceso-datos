package org.example.Ej7;


import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String resultado;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    @ManyToMany
    @JoinTable(
        name = "partido_arbitro",
        joinColumns = @JoinColumn(name = "partido_id"),
        inverseJoinColumns = @JoinColumn(name = "arbitro_id")
    )
    private Set<Arbitro> arbitros;

    @OneToMany(mappedBy = "partido")
    private Set<Estadistica> estadisticas;

    // Getters and setters
}