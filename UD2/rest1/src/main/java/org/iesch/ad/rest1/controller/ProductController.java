package org.iesch.ad.rest1.controller;

import org.iesch.ad.rest1.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {
    @Autowired
    ProductoService productoService;
    @GetMapping("api/getTodo")
    public ResponseEntity<?> getTodos(){
        return ResponseEntity.ok(productoService);
    }

    @GetMapping("api/getOne/{id}")

}
