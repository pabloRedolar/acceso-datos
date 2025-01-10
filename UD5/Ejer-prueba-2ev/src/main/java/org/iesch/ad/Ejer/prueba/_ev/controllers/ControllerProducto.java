package org.iesch.ad.Ejer.prueba._ev.controllers;

import org.iesch.ad.Ejer.prueba._ev.models.DTOs.ProductoDTO;
import org.iesch.ad.Ejer.prueba._ev.models.DTOs.ProductoDTOConverter;
import org.iesch.ad.Ejer.prueba._ev.models.Producto;
import org.iesch.ad.Ejer.prueba._ev.repositories.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")

public class ControllerProducto {
    @Autowired
    RepositorioProducto repositorioProducto;

    @Autowired
    ProductoDTOConverter productoDTOConverter;

    @GetMapping("productos")
    public ResponseEntity<?> getProductos() {
        List<Producto> resultado = repositorioProducto.findAll();
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("productoDTO")
    public ResponseEntity<?> obtenerTodosMedianteDTO() {
        List<Producto> resultado = repositorioProducto.findAll();

        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<ProductoDTO> resultadoDTO = resultado.stream().map(productoDTOConverter::convertirADTO).toList();

            return ResponseEntity.ok(resultadoDTO);
        }

    }
}
