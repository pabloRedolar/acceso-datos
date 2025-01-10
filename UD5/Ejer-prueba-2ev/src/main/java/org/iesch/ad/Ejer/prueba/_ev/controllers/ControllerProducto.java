package org.iesch.ad.Ejer.prueba._ev.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/api")
@Tag(name = "Productos", description = "Api para la gestion de productos")
public class ControllerProducto {
    @Autowired
    RepositorioProducto repositorioProducto;

    @Autowired
    ProductoDTOConverter productoDTOConverter;

    @Operation(summary = "Buscar todos lo productos")
    @CrossOrigin(origins = "")
    @GetMapping("productos")
    public ResponseEntity<?> getProductos() {
        List<Producto> resultado = repositorioProducto.findAll();
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Obtener todos productos a traves de un DTO")
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

    @GetMapping("/saluda")
    public ResponseEntity<?> saluda() {
        return ResponseEntity.ok("Holiiiiiiiiiii");
    }
}
