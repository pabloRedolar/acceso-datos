package org.iesch.ad.crudpersonas.models;

import org.iesch.ad.crudpersonas.models.Direccion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Persona {
    @Id
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private List<String> intereses;

    private Direccion direccion;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellidos, int edad, List<String> intereses, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.intereses = intereses;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
