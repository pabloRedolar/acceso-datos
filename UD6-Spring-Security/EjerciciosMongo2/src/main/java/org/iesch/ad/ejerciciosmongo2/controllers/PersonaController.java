package org.iesch.ad.ejerciciosmongo2.controllers;

import org.iesch.ad.ejerciciosmongo2.models.Persona;
import org.iesch.ad.ejerciciosmongo2.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPersonas(@RequestBody List<Persona> personas) {
        personaRepository.saveAll(personas);

        return ResponseEntity.status(HttpStatus.OK).body(personaRepository.saveAll(personas));
    }


//1: Buscar todas las personas que viven en una determinada ciudad, por ejemplo en Madrid, la ciudad debe ser pasada como un parámetro a través de la URL.

    @GetMapping("/buscarPorCiudad/{ciudad}")
    public ResponseEntity<?> buscarPorCiudad(@PathVariable String ciudad) {
        List<Persona> personas = personaRepository.findPersonasByCiudad(ciudad);

        if (personas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personas);
        }
        return ResponseEntity.status(HttpStatus.OK).body(personas);
    }

//2: Buscar todas las personas cuyo nombre comience por una determinada letra, la letra debe ser pasada como un parámetro a través de la URL, puedes probar con "A", pero si pasas más de un carácter debe darnos un error.

    @GetMapping("buscarPorPrimeraLetraNombre/{letra}")
    public ResponseEntity<?> buscarPorPrimeraLetraNombre(@PathVariable String letra) {

        if (letra.length() > 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No puedes pasar mas de una letra");
        } else {
            List<Persona> personas = personaRepository.findPersonasByNombreStartsWith(letra);

            return ResponseEntity.status(HttpStatus.OK).body(personas);
        }
    }

//3: Buscar todas las personas que estén en un rango de edad. Por ejemplo, que tengan entre 25 y 35 años. Ambas edades deben ser pasadas como parámetros a través de la URL.

    @GetMapping("buscarPorRangoEdad/{menor},{mayor}")
    public ResponseEntity<?> buscarPorRangoEdad(@PathVariable int menor, @PathVariable int mayor) {

        List<Persona> personas = personaRepository.findPersonasByEdadBetween(menor, mayor);

        return ResponseEntity.ok(personas);
    }

//4: Buscar todas las personas que tengan un interés determinado, el interés debe ser pasado por url. Prueba con "música" como interés.

    @GetMapping("/buscarPorInteres/{interes}")
    public ResponseEntity<?> buscarPorInteres(@PathVariable String interes) {

        List<Persona> personas = personaRepository.findPersonasByInteresesContains(interes);

        return ResponseEntity.ok(personas);
    }

//5: Buscar todas las personas que vivan en una ciudad que comience con una determinada letra, prueba con la letra "B".

    @GetMapping("buscarPorPrimeraLetraCiudad/{letra}")
    public ResponseEntity<?> buscarPorPrimeraLetraCiudad(@PathVariable String letra) {

        if (letra.length() > 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No puedes pasar mas de una letra");
        } else {
            List<Persona> personas = personaRepository.findPersonasByNombreStartsWith(letra);

            return ResponseEntity.status(HttpStatus.OK).body(personas);
        }
    }

//6: Buscar todas las personas cuyo apellido termine en un determinado carácter, por ejemplo "z".

    @GetMapping("buscarPorApellidoUltimaLetra/{letra}")
    public ResponseEntity<?> buscarPorApellidoUltimaLetra(@PathVariable String letra) {

        return ResponseEntity.ok(personaRepository.buscarPorApellidoUltimaLetra(letra));
    }

//7: Buscar todas las personas que tengan al menos X años y vivan en una ciudad cuyo nombre tenga exactamente X letras. Puedes probar con 30 años y 6 letras.


//8: Buscar todas las personas que vivan en una calle que contenga una palabra pasada como parámetro, puedes probar con "Calle".


//9: Buscar todas las personas cuyo interés incluya una subcadena. Puedes probar con "tecnología".


//10 Buscar todas las personas cuyo nombre contenga un substring  (ignorando mayúsculas y minúsculas). Prueba con "an".


}
