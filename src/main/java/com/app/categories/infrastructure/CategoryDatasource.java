package com.app.categories.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.categories.domain.ICategoryRepository;
import com.app.categories.domain.Category;

@Component
public class CategoryDatasource {

    private final ICategoryRepository categoryRepository;

    public CategoryDatasource(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> update(Category category, Long id) {
        return categoryRepository.findById(id).map(existCategory -> {
            existCategory.setName(category.getName());
            
            return categoryRepository.save(existCategory);
        });
    }

    public boolean deleteById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
