package com.app.categories.domain;

import java.util.List;


public interface ICategoryService {
    
    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    Category update(Category category, Long id);

    void deleteById(Long id);
}
