package org.iesch.primerRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
class PrimerRestAplication {
    public static void main(String[] args) {
        SpringApplication.run(PrimerRestAplication.class, args);
		hello("Pablo");
    }

    @GetMapping("/hello")
    public static String hello(@RequestParam(value = "name", defaultValue = "Manue") String name) {
        return String.format("Hello %s!", "Pablo");
    }

    @GetMapping("/holajson")
    public Map<String, String> holaJson(){
        Map<String, String> map = new HashMap<>();
        map.put("Juan", "Margaix");
        map.put("Manue", "Julve");
        map.put("Pablo", "Redolar");
        return map;
    }
}
