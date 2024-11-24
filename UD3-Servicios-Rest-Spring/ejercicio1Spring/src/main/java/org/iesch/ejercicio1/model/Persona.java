package org.iesch.ejercicio1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    String nombre;
    String apellido;
}

