package org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class ClienteDTO {
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String telefono;

    public ClienteDTO(String nif, String nombre, String apellidos, String direccion, String ciudad, String telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public ClienteDTO(String nif, String nombre, String ciudad) {
        this.nif = nif;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public ClienteDTO() {
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
