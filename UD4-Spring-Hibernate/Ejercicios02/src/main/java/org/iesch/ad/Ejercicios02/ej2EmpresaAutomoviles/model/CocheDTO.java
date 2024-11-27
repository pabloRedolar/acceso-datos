package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model;

import lombok.Data;


@Data
public class CocheDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double precio;

    private Cliente cliente;

}
