package org.iesch.ad.Ejercicios02.ej1EmpresaTransportes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String nombre;

    @OneToMany (mappedBy = "provincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Paquete> paqueteSet = new HashSet<>();
}
