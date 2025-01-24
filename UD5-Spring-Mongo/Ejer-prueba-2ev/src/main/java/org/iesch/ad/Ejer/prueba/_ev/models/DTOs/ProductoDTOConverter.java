package org.iesch.ad.Ejer.prueba._ev.models.DTOs;

import jakarta.persistence.Converter;
import org.iesch.ad.Ejer.prueba._ev.models.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoDTOConverter {
    @Autowired
    ModelMapper modelMapper;

    public ProductoDTO convertirADTO(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);
    }

    public Producto convertDesdeDTO(ProductoDTOCreado productoDTOCreado) {
        return modelMapper.map(productoDTOCreado, Producto.class);
    }

}
