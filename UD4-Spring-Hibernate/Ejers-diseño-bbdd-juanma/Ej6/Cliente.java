package org.example.Ej6;



import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private Set<Venta> ventas;

    // Getters and setters
}