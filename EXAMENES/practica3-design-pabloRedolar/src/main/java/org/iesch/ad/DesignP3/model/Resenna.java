package org.iesch.ad.DesignP3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter

public class Resenna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contenido;
    private LocalDate fecha_creacion;
    private Double calificacion;

    @OneToOne(mappedBy = "resenna")
    private Libro libro;
}
