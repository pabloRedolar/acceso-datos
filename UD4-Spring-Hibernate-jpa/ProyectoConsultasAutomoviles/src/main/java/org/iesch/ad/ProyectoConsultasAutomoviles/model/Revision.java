package org.iesch.ad.ProyectoConsultasAutomoviles.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity


public class Revision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Boolean cambioFiltro;
    private Boolean cambioAceite;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coche")
    @JsonBackReference
    private Coche coche;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getCambioFiltro() {
        return cambioFiltro;
    }

    public void setCambioFiltro(Boolean cambioFiltro) {
        this.cambioFiltro = cambioFiltro;
    }

    public Boolean getCambioAceite() {
        return cambioAceite;
    }

    public void setCambioAceite(Boolean cambioAceite) {
        this.cambioAceite = cambioAceite;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }
}
