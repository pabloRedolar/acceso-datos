package org.iesch.ad.ejemploExcepciones.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Usuario {
    long id;
    String nombre;
    String apellidos;

}
