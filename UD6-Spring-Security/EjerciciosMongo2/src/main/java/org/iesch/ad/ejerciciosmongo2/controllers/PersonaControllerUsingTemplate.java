package org.iesch.ad.ejerciciosmongo2.controllers;

import org.iesch.ad.ejerciciosmongo2.models.Persona;
import org.iesch.ad.ejerciciosmongo2.service.PersonaServiceUsingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaControllerUsingTemplate {

    @Autowired
    PersonaServiceUsingTemplate personaServiceUsingTemplate;

    //6: Buscar todas las personas cuyo apellido termine en un determinado carácter, por ejemplo "z".

    @GetMapping("/buscarPorApellidoUltimaLetra/{letra}")
    public ResponseEntity<?> buscarPorApellidoUltimaLetra(@PathVariable String letra) {
        List<Persona> personas = personaServiceUsingTemplate.buscarPorApellidoUltimaLetra(letra);

        return ResponseEntity.ok(personas);
    }

//7: Buscar todas las personas que tengan al menos X años y vivan en una ciudad cuyo nombre tenga exactamente X letras. Puedes probar con 30 años y 6 letras.

    @GetMapping("/buscarPorAnnosYCiudadConXLetras/{annos}/{cantidadLetras}")
    public ResponseEntity<?> buscarPorAnnosYCiudadConXLetras(@PathVariable int annos, @PathVariable int cantidadLetras) {
        List<Persona> personas = personaServiceUsingTemplate.buscarPorAnnosYCiudadConXLetras(annos, cantidadLetras);

        return ResponseEntity.ok(personas);
    }

//8: Buscar todas las personas que vivan en una calle que contenga una palabra pasada como parámetro, puedes probar con "Calle".

    @GetMapping("/buscarPorPalabraEnCalle")
    public ResponseEntity<?> buscarPorPalabraEnCalle(@RequestParam String palabra) {

        List<Persona> personas = personaServiceUsingTemplate.buscarPorPalabraEnCalle(palabra);

        return ResponseEntity.status(HttpStatus.OK).body(personas);
    }

//9: Buscar todas las personas cuyo interés incluya una subcadena. Puedes probar con "tecnología".

    @GetMapping("/buscarPorInteresSubcadena/{cadena}")
    public ResponseEntity<?> buscarPorInteresSubcadena(@PathVariable String cadena) {

        List<Persona> personas = personaServiceUsingTemplate.buscarPorInteresSubcadena(cadena);
        return ResponseEntity.ok(personas);

    }

//10 Buscar todas las personas cuyo nombre contenga un substring (ignorando mayúsculas y minúsculas). Prueba con "an".

    @GetMapping("buscarPorNombreContieneCadena/{cadena}")
    public ResponseEntity<?> buscarPorNombreContieneCadena(@PathVariable String cadena) {

        List<Persona> personas = personaServiceUsingTemplate.buscarPorNombreContieneCadena(cadena);

        return ResponseEntity.ok(personas);

    }

}
