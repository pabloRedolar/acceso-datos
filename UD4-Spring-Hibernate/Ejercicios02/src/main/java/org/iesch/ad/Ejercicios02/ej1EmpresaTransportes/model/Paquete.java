package org.iesch.ad.Ejercicios02.ej1EmpresaTransportes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private String descripcion;
    private String destinatario;
    private String direccionDestinatario;

    @ManyToOne
    @JoinColumn (name = "camionero_id", referencedColumnName = "dni")
    private Camionero camionero;

    @ManyToOne
    @JoinColumn (name = "provincia_id")

    Provincia provincia;


}
