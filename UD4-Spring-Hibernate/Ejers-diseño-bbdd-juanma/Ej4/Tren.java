package org.example.Ej4;



import jakarta.persistence.*;

@Entity
public class Tren {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int numeroVagones;

    @ManyToOne
    @JoinColumn(name = "cochera_id")
    private Cochera cochera;

    @ManyToOne
    @JoinColumn(name = "linea_id")
    private Linea linea;

    // Getters and setters
}
