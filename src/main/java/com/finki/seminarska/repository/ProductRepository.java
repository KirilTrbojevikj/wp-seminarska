package com.finki.seminarska.repository;

import com.finki.seminarska.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByName(String name);
}
