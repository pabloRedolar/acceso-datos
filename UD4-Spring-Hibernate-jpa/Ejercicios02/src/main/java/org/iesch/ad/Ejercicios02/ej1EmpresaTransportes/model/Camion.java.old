package org.iesch.ad.Ejercicios02.ej1EmpresaTransportes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Camion {
    @Id
    private String matricula;
    private String modelo;
    private String tipo;
    private int potencia;

    @ManyToMany(mappedBy = "camiones")
    private Set<Camionero> camioneros = new HashSet<>();
}
