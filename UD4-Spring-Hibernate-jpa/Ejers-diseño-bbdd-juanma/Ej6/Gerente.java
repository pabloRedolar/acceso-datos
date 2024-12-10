package org.example.Ej6;


import jakarta.persistence.*;

@Entity
public class Gerente extends Empleado {
    private int aniosEnEmpresa;

    @OneToMany(mappedBy = "gerente")
    private Set<Jefe> jefes;

    // Getters and setters
}
