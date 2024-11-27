package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean cambioFiltro;
    private boolean cambioAceite;

//    @ManyToOne
//    @JoinColumn (name = "coche_id")
//    private Coche coche;
}
