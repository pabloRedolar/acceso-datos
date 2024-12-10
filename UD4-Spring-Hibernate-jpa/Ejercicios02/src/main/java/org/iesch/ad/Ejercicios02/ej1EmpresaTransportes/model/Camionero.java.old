package org.iesch.ad.Ejercicios02.ej1EmpresaTransportes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Camionero {
    @Id
    String dni;
    String nombre;
    int telefono;
    String direccion;
    float salario;
    String poblacion;

    @OneToMany(mappedBy = "camionero", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Paquete> paquetes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "camionero_camion", joinColumns = @JoinColumn (name = "camionero_dni"), inverseJoinColumns = @JoinColumn(name = "camion_matricula"))
    private Set<Camion> camiones = new HashSet<>();
}
