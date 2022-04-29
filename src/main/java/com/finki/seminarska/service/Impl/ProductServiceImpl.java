package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.model.Product;
import com.finki.seminarska.model.exceptions.CategoryNotFoundException;
import com.finki.seminarska.repository.CategoryRepository;
import com.finki.seminarska.repository.ProductRepository;
import com.finki.seminarska.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> save(String name, Double price, String description, Category category) {

        this.productRepository.deleteByName(name);
        return Optional.of(this.productRepository.save(new Product(name, price, description, category)));
    }

    @Override
    public Optional<Product> save(String name, Double price, String description, Long categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        this.productRepository.deleteByName(name);
        return Optional.of(this.productRepository.save(new Product(name, price, description, category)));
    }

    @Override
    public Optional<Product> edit(String name, Double price, String description, Long categoryId) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        product.setCategory(category);

        return Optional.of(this.productRepository.save(product));
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
