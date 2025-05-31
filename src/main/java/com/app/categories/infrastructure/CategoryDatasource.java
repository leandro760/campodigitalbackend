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

    public categ save(Category category) {
        return userRepository.save(user);
    }

    public Optional<User> update(User user, Long id) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFullName(user.getFullName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        });
    }

    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
