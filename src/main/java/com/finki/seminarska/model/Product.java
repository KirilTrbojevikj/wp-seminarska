package com.finki.seminarska.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private Category category;
    private Double price;
    private String description;

    public Product() {
    }

    public Product(String name, Double price, String description, Category category) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
}
