package org.iesch.ejercicio1.service;

import org.springframework.stereotype.Service;

@Service

public class Conversor {

    private final double RATIOKMMILLAS = 1.69034;
    public double convertirAkm(Double millas){
        return millas * RATIOKMMILLAS;
    }

    public double convertirAMillas(Double km){
        return km / RATIOKMMILLAS;
    }

    public double covertirAfahreneith(double temperatura) {
        return  (temperatura * 9/5) + 32;
    }
}
