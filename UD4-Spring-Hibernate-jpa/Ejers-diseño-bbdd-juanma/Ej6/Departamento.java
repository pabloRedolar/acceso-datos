package org.example.Ej6;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String planta;

    @OneToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    @OneToMany(mappedBy = "departamento")
    private Set<Empleado> empleados;

    @OneToMany(mappedBy = "departamento")
    private Set<Articulo> articulos;

    // Getters and setters
}
