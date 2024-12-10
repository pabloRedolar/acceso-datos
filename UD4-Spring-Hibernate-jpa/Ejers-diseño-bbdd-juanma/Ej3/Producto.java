package org.example.Ej3;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descripcion;
    private double precio;
    private int existencias;

    @ManyToMany(mappedBy = "productos")
    @JsonBackReference
    private Set<Cliente> clientes;

    @ManyToMany
    @JoinTable(
        name = "producto_proveedor",
        joinColumns = @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    @JsonManagedReference
    private Set<Proveedor> proveedores;

    // Getters and setters
}