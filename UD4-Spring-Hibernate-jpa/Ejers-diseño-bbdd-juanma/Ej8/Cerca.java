package org.example.Ej8;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Cerca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String situacion;
    private String servicios;

    @OneToMany(mappedBy = "cerca")
    private Set<Animal> animales;

    // Getters and setters
}
