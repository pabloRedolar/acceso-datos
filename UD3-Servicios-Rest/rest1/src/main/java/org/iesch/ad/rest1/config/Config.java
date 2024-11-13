package org.iesch.ad.rest1.config;

import org.iesch.ad.rest1.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration

public class Config {
    @Bean
    public List<Product> inicializa(){
        List<Product> productos = new ArrayList<>();
        productos.add(Product.builder()
                .id(1)
                .name("Huevos")
                .category("Alimentos")
                .price(2.99)
                .description("Huevos frescos de gallina de corral")
                .stock(10)
                .build());
        productos.add(Product.builder()
                .id(2)
                .name("Leche")
                .category("Alimentos")
                .price(1.79)
                .description("Lechita rica rica")
                .stock(20)
                .build());
        productos.add(Product.builder()
                .id(3)
                .name("Azucar")
                .category("Alimentos")
                .price(1.00)
                .description("Asuuuucar")
                .stock(8)
                .build());
        productos.add(Product.builder()
                .id(4)
                .name("Harina")
                .category("Alimentos")
                .price(0.75)
                .description("Harina freskita")
                .stock(15)
                .build());
        productos.add(Product.builder()
                .id(5)
                .name("Levadura")
                .category("Alimentos")
                .price(0.55)
                .description("Levadura de la dura")
                .stock(25)
                .build());


        return productos;
    }
}
