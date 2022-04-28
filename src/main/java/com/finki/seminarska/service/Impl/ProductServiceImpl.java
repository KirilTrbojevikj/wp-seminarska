package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Product;
import com.finki.seminarska.repository.ProductRepository;
import com.finki.seminarska.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> save(String name, Double price, String description, Category category) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> edit(Long id, String name, Double price, String description, Category category) {
        return Optional.empty();
    }

    @Override
    public void DeleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }
}
