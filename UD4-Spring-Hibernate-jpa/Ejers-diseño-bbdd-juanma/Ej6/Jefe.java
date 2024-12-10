package org.example.Ej6;

package org.example;

import jakarta.persistence.*;

@Entity
public class Jefe extends Empleado {
    private double salario;

    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    @OneToMany(mappedBy = "jefe")
    private Set<Vendedor> vendedores;

    // Getters and setters
}
