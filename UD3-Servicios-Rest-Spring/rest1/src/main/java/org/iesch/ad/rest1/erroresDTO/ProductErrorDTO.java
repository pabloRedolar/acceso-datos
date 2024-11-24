package org.iesch.ad.rest1.erroresDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductErrorDTO {
    String message;
    String error;
    int status;
    LocalDateTime date;
}
