package org.iesch.ad.EjemploBusquedasFeching.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;
    String nombre;



}
