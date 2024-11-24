package org.iesch.ad.ejemploExcepciones.erroresDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private String error;
    private int status;
    private LocalDate date;

}
