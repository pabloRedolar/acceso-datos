package org.iesch.ad.Ej2.models;

import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document(value = "personas")
public class Persona {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String dni;
    private LocalDate fechanacimineto;

    private List<Licencia> licencias = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Persona() {
    }

    public Persona(String id, String nombre, String apellido, String direccion, String telefono, String dni, LocalDate fechanacimineto, List<Licencia> licencias, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.fechanacimineto = fechanacimineto;
        this.licencias = licencias;
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechanacimineto() {
        return fechanacimineto;
    }

    public void setFechanacimineto(LocalDate fechanacimineto) {
        this.fechanacimineto = fechanacimineto;
    }

    public List<Licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", dni='" + dni + '\'' +
                ", fechanacimineto=" + fechanacimineto +
                ", licencias=" + licencias +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
