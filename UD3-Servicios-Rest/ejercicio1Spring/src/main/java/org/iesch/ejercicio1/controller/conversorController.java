package org.iesch.ejercicio1.controller;

import org.iesch.ejercicio1.service.Conversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class conversorController {
    @Autowired
    Conversor conversor;

    @GetMapping("/conDistancia/{km}")
    public Map<String, Double> conversorDistancia(@PathVariable double km){
        Map<String, Double> mapDevolver = new HashMap<>();

        double millas = conversor.convertirAMillas(km);

        mapDevolver.put("La conversion de " + (km) + " km a millas es: ", millas);
        return mapDevolver;
    }

    @GetMapping("conTemp/{grados}")
    public Map<String, Double> convertidorTemperatura(@PathVariable double grados){
        Map<String, Double> mapConversionTemp = new HashMap<>();

        double temperaturaEnFahrenheit = conversor.covertirAfahreneith(grados);
        mapConversionTemp.put("Temperatura en Fahrenheit es: ", temperaturaEnFahrenheit);
        return mapConversionTemp;
    }
}
