package org.example.Ej3;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String provincia;
    private String telefono;

    @ManyToMany(mappedBy = "proveedores")
    @JsonBackReference
    private Set<Producto> productos;

    // Getters and setters
}
