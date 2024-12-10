package org.example.Ej4;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Cochera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    @OneToMany(mappedBy = "cochera")
    private Set<Tren> trenes;

    // Getters and setters
}