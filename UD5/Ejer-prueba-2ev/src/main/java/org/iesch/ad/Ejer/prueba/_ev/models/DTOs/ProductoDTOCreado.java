package org.iesch.ad.Ejer.prueba._ev.models.DTOs;

public class ProductoDTOCreado {
    private String nombre;
    private Float precio;
    private Long caregoriaId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Long getCaregoriaId() {
        return caregoriaId;
    }

    public void setCaregoriaId(Long caregoriaId) {
        this.caregoriaId = caregoriaId;
    }
}
