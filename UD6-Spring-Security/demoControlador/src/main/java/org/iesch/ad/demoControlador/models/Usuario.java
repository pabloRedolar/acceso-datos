package org.iesch.ad.demoControlador.models;

public class Usuario {
    String nombre;
    Integer edad;

    public Usuario(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
