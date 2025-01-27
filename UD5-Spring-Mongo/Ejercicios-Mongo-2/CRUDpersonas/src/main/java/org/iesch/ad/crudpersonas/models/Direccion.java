package org.iesch.ad.crudpersonas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Direccion {
    @Id
    private Long id;
    private String ciudad;
    private String calle;
    private String numero;
    private String piso;
    private String codigo_postal;

    public Direccion() {
    }

    public Direccion(Long id, String ciudad, String calle, String numero, String piso, String codigo_postal) {
        this.id = id;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.codigo_postal = codigo_postal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
}
