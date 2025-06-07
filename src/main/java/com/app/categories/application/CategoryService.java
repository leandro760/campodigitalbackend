package com.app.categories.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.categories.domain.Category;
import com.app.categories.domain.ICategoryRepository;
import com.app.categories.domain.ICategoryService;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    }

    @Override
    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category update(Category category, Long id) {
        Category existingCategory = findById(id);
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }
}
