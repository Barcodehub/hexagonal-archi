package com.example.producthexagonal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;
    private Double price;

    public void validatePrice() {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
    }
}