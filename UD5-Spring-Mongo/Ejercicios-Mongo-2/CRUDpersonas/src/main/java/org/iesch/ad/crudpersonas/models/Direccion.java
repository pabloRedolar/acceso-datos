package org.iesch.ad.crudpersonas.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Direccion {
    //    @Id
//    private Long id;
    private String calle;
    private String numero;
    private String ciudad;
//    private String piso;
//    private String codigo_postal;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
