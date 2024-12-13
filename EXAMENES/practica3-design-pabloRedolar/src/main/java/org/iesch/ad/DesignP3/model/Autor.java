package org.iesch.ad.DesignP3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private String nacionalidad;

    @OneToMany(mappedBy = "autor")
    private Set<Libro> libros = new HashSet<>();
}
