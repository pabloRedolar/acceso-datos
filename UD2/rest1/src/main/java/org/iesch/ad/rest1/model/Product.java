package org.iesch.ad.rest1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    long id;
    String name;
    double price;
    String description;
    String category;
    int stock;

}
