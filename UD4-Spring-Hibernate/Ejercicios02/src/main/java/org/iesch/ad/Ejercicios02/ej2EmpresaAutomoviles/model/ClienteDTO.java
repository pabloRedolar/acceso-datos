package org.iesch.ad.Ejercicios02.ej2EmpresaAutomoviles.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteDTO {
    private long id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String ciudad;
    private String telefono;

    private List<CocheDTO> cochesDTO = new ArrayList<>();

}
