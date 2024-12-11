package org.iesch.ad.Ejercicios02.ej3TiendaInformatica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String provincia;
    private String telefono;


    @ManyToMany(mappedBy = "proveedores")

    private Set<Producto> productos = new HashSet<>();
}
