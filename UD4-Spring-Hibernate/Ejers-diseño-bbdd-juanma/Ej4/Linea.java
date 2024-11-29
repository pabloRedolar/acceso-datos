package org.example.Ej4;



import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    @OneToMany(mappedBy = "linea")
    private Set<Tren> trenes;

    // Getters and setters
}