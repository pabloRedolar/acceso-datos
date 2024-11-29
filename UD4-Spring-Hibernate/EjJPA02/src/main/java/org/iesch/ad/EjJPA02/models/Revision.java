package org.iesch.ad.EjJPA02.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private boolean cambioFiltro;
    private boolean cambioAceite;

    @ManyToOne
    @JoinColumn(name = "coche_id")

    @JsonManagedReference
    private Coche coche;
}
