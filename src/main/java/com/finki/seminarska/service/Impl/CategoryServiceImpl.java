package com.finki.seminarska.service.Impl;

import com.finki.seminarska.model.Category;
import com.finki.seminarska.repository.CategoryRepository;
import com.finki.seminarska.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();

    }
}
