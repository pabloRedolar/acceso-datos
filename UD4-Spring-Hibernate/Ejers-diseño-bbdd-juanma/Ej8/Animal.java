package org.example.Ej8;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroIdentificacion;
    private String raza;
    private Date fechaNacimiento;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "cerca_id")
    private Cerca cerca;

    // Getters and setters
}