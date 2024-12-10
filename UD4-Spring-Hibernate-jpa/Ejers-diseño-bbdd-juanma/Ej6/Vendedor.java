package org.example.Ej6;

package org.example;

import jakarta.persistence.*;

@Entity
public class Vendedor extends Empleado {
    private double salario;

    @ManyToOne
    @JoinColumn(name = "jefe_id")
    private Jefe jefe;

    @OneToMany(mappedBy = "vendedor")
    private Set<Venta> ventas;

    // Getters and setters
}
