package org.iesch.org.demoGenerateJWT.controllers;

import io.jsonwebtoken.Claims;
import org.iesch.org.demoGenerateJWT.utilJWT.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Map;

@RestController
public class ControllerJWT {

    @Autowired
    private JWTutil JWTutil;

    //Ejer 1
    @GetMapping("/ej1")
    public ResponseEntity<?> getClaims(@RequestParam String token) {
        Claims claims = JWTutil.extractAllClaims(token);
        System.out.println(claims);

        return ResponseEntity.ok(claims);
    }

    //Ejer 2
    @GetMapping("/ej2")
    public ResponseEntity<?> validarToken(@RequestParam String token) {

        if (JWTutil.validaToken(token)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pa lante");
        } else return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body("Ta fatal eso wey");

    }

    //Ejer 3
    @GetMapping("/ej3")
    public ResponseEntity<?> extraerInformacion(@RequestParam String token, @RequestParam String claimExtraer) {
        Claims claims = JWTutil.extractAllClaims(token);

        return ResponseEntity.ok(claims.get(claimExtraer, String.class));

    }

    //Ejer 5
    @GetMapping("/ej5")
    public ResponseEntity<?> extraerExp(@RequestParam String token) {
//        Claims claims = JWTutil.extractAllClaims(token);

        return ResponseEntity.ok(JWTutil.extractClaimExpiration(token));

    }

    //Ejer 6
    @GetMapping("/ej6")
    public ResponseEntity<?> generaConMaxClaims() {
        String token = JWTutil.generateToken("pabloRedolar");

        return ResponseEntity.ok(token);

    }

}
