package Persona;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Persona {
    String nombre;
    int edad;
    String apellidos;
    String dni;
    String direccion;
}


