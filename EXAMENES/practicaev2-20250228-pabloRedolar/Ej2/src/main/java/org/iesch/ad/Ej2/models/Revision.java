package org.iesch.ad.Ej2.models;

import java.time.LocalDate;

public class Revision {
    private Boolean resultado;
    private LocalDate fecha;
    private LocalDate valido_hasta;

    public Revision(Boolean resultado, LocalDate fecha, LocalDate valido_hasta) {
        this.resultado = resultado;
        this.fecha = fecha;
        this.valido_hasta = valido_hasta;
    }

    public Revision() {
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getValido_hasta() {
        return valido_hasta;
    }

    public void setValido_hasta(LocalDate valido_hasta) {
        this.valido_hasta = valido_hasta;
    }
}
