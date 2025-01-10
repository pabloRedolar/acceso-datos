package org.iesch.ad.Ej2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Raqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private Double precio;


    @OneToOne
    @JoinColumn(name = "representante_id")

    @JsonBackReference

    private Representante representante;


    @OneToMany(mappedBy = "raqueta")

    @JsonManagedReference

    private Set<Tenista> tenistas = new HashSet<>();

    public Raqueta(Long id, String marca, Double precio, Representante representante, Set<Tenista> tenistas) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
        this.representante = representante;
        this.tenistas = tenistas;
    }

    public Raqueta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Set<Tenista> getTenistas() {
        return tenistas;
    }

    public void setTenistas(Set<Tenista> tenistas) {
        this.tenistas = tenistas;
    }
}
