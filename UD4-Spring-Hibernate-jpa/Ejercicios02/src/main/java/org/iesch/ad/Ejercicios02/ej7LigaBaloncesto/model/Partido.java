package org.iesch.ad.Ejercicios02.ej7LigaBaloncesto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_equipo_local")
    private Equipo equipoLocal;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo_visitante")
    private Equipo equipoVisitante;


    @ManyToOne
    @JoinColumn(name = "id_arbitro1")
    private Arbitro arbitro1;

    @ManyToOne
    @JoinColumn(name = "id_arbitro2")
    private Arbitro arbitro2;

    @ManyToOne
    @JoinColumn(name = "id_arbitro3")
    private Arbitro arbitro3;

    @OneToMany(mappedBy = "partido")
    private Set<Estadistica> estadisticas = new HashSet<>();

}
