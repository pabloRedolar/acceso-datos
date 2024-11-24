package com.ad.gestionDeReservasDeUnHotel.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class User {

    long id;
    String name;
    String email;
}