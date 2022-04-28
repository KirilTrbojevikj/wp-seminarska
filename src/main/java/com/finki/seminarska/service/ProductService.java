package com.finki.seminarska.service;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> save(String name, Double price, String description, Category category);

    Optional<Product> edit(Long id, String name, Double price, String description, Category category);

    void DeleteById(Long id);

    Optional<Product> findById(Long id);

}
