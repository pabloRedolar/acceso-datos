package org.iesch.ad.Ej2.models;

import java.util.List;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private TipoVehiculo tipo;
    private int cilindrada;
    private int numero_cilindros;
    private List<Revision> revisiones;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, TipoVehiculo tipo, int cilindrada, int numero_cilindros, List<Revision> revisiones) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.cilindrada = cilindrada;
        this.numero_cilindros = numero_cilindros;
        this.revisiones = revisiones;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getNumero_cilindros() {
        return numero_cilindros;
    }

    public void setNumero_cilindros(int numero_cilindros) {
        this.numero_cilindros = numero_cilindros;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }
}
