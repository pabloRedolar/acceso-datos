package Persona;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Persona {
    private String nombre;
    private int edad;
    private String apellidos;
    private String dni;
    private String direccion;
}


