package org.example.Ej5;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoEmpleado;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String nif;
    private String nss;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Getters and setters
}