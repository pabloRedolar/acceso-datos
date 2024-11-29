package org.example.Ej8;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class AnimalVenta extends Animal {
    private Date fechaVenta;
    private double precioVenta;

    // Getters and setters
}
