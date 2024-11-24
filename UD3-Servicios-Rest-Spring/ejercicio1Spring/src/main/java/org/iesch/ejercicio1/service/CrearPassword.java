package org.iesch.ejercicio1.service;

public class CrearPassword {
    public String generaLetras() {
        String palabra = "";

        int caracteres = (int) (Math.random() * 20) + 2;
        for (int i = 0; i < caracteres; i++) {

            int codigoAscii = (int) Math.floor(Math.random() * (122 - 97) + 97);
            palabra = palabra + (char) codigoAscii;
        }
        return palabra;
    }
}
