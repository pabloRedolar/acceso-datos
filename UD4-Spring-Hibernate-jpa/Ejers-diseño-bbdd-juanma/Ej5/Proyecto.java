package org.example.Ej5;



import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "proyecto_padre_id")
    private Proyecto proyectoPadre;

    @OneToMany(mappedBy = "proyectoPadre")
    private Set<Proyecto> subProyectos;

    // Getters and setters
}
