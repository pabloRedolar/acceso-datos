package org.iesch.ad.DesignP3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

public class Libro {
    @Id
    private String isbn;

    private String titulo;
    private LocalDate fecha_publicacion;
    private Double precio;


    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;


    @OneToMany
    @JoinTable(name = "libros_categorias", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();


    @ManyToOne
//    @JoinColumn(name = "libro_id")
    private Editorial editorial;


    @OneToOne
    @JoinColumn(name = "resenna_id")
    private Resenna resenna;
}
