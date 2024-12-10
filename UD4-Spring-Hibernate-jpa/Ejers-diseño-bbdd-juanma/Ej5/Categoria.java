package org.example.Ej5;

package org.example;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private double salario;

    @OneToMany(mappedBy = "categoria")
    private Set<Empleado> empleados;

    // Getters and setters
}
