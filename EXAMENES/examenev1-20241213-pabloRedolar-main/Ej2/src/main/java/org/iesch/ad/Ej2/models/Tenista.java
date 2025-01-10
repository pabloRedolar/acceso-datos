package org.iesch.ad.Ej2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity

public class Tenista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int ranking;
    private LocalDate fechaNacimiento;
    private int annoProfesional;
    private Double altura;
    private Double peso;
    private String manoDominante;
    private String tipoReves;
    private int puntos;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "raquetaID")

    @JsonBackReference

    private Raqueta raqueta;

    public Tenista(Long id, String nombre, int ranking, LocalDate fechaNacimiento, int annoProfesional, Double altura, Double peso, String manoDominante, String tipoReves, int puntos, String pais, Raqueta raqueta) {
        this.id = id;
        this.nombre = nombre;
        this.ranking = ranking;
        this.fechaNacimiento = fechaNacimiento;
        this.annoProfesional = annoProfesional;
        this.altura = altura;
        this.peso = peso;
        this.manoDominante = manoDominante;
        this.tipoReves = tipoReves;
        this.puntos = puntos;
        this.pais = pais;
        this.raqueta = raqueta;
    }

    public Tenista() {
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAnnoProfesional() {
        return annoProfesional;
    }

    public void setAnnoProfesional(int annoProfesional) {
        this.annoProfesional = annoProfesional;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getManoDominante() {
        return manoDominante;
    }

    public void setManoDominante(String manoDominante) {
        this.manoDominante = manoDominante;
    }

    public String getTipoReves() {
        return tipoReves;
    }

    public void setTipoReves(String tipoReves) {
        this.tipoReves = tipoReves;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }

    public void setRaqueta(Raqueta raqueta) {
        this.raqueta = raqueta;
    }
}
