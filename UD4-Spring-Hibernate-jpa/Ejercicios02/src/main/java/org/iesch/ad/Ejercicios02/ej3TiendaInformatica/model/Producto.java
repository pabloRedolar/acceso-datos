package org.iesch.ad.Ejercicios02.ej3TiendaInformatica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;
    private Float precio;
    private Long existencias;


    @OneToMany(mappedBy = "producto")
    private Set<Compras> compras = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "producto_proveedor",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_proveedor"))

    private Set<Proveedor> proveedores = new HashSet<>();

}
