package org.iesch.ad.proyectoPassword.erroresDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioErrorDTO {
    String message;
    String error;
    int status;
    LocalDateTime date;
}
