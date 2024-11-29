package org.example.Ej5;



import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoDepartamento;
    private String nombre;

    @OneToOne
    @JoinColumn(name = "jefe_id")
    private Empleado jefe;

    @ManyToOne
    @JoinColumn(name = "departamento_padre_id")
    private Departamento departamentoPadre;

    @OneToMany(mappedBy = "departamento")
    private Set<Empleado> empleados;

    @OneToMany(mappedBy = "departamento")
    private Set<Proyecto> proyectos;

    // Getters and setters
}