package org.iesch.ad.Ej2.models;

import java.time.LocalDate;
import java.util.Date;

public class Licencia {
    private String tipo;
    private LocalDate fecha_expedicion;
    private LocalDate fecha_expiracion;

    public Licencia(String tipo, LocalDate fecha_expedicion, LocalDate fecha_expiracion) {
        this.tipo = tipo;
        this.fecha_expedicion = fecha_expedicion;
        this.fecha_expiracion = fecha_expiracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(LocalDate fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    public LocalDate getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(LocalDate fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }
}
