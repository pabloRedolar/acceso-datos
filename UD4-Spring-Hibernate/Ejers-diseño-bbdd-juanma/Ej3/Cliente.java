package org.example.Ej3;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;

    @ManyToMany
    @JoinTable(
        name = "cliente_producto",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    @JsonManagedReference
    private Set<Producto> productos;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private Set<Compra> compras;

    // Getters and setters
}
