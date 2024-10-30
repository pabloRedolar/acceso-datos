package org.iesch.ad.rest1.service;

import org.iesch.ad.rest1.excepciones.ProductNotFoundException;
import org.iesch.ad.rest1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    List<Product> productos;

    public List<Product> obtenerTodos(){
        return productos;
    }

    public Optional<Product> obtenerUno(Long id){
        return productos.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(() -> new ProductNotFoundException);
    }
}
