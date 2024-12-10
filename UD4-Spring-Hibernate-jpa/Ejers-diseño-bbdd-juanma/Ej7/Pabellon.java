package org.example.Ej7;



import jakarta.persistence.*;

@Entity
public class Pabellon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int aforo;
    private Date fechaConstruccion;

    @OneToOne(mappedBy = "pabellon")
    private Equipo equipo;

    // Getters and setters
}
