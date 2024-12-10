package org.example.Ej4;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "estacion")
    private Set<Cochera> cocheras;

    @OneToMany(mappedBy = "estacion")
    private Set<Linea> lineas;

    // Getters and setters
}
