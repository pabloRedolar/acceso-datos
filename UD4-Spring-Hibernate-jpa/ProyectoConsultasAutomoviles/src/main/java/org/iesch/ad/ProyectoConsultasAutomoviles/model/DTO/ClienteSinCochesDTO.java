package org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter

public class ClienteSinCochesDTO {
    private String nif;
    private String nombre;
    private Long cantidadCoches;
    private Double precioCoches;

    public ClienteSinCochesDTO(String nif, String nombre, Long cantidadCoches, Double precioCoches) {
        this.nif = nif;
        this.nombre = nombre;
        this.cantidadCoches = cantidadCoches;
        this.precioCoches = precioCoches;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidadCoches() {
        return cantidadCoches;
    }

    public void setCantidadCoches(Long cantidadCoches) {
        this.cantidadCoches = cantidadCoches;
    }

    public Double getPrecioCoches() {
        return precioCoches;
    }

    public void setPrecioCoches(Double precioCoches) {
        this.precioCoches = precioCoches;
    }
}
