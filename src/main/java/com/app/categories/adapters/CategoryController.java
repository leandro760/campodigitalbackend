package com.app.categories.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.categories.domain.ICategoryService;
import com.app.categories.domain.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return categories.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(categories);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
            
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.save(category);
        return ResponseEntity.status(201).body(newCategory);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updateCategory = categoryService.update(category,id);
        return ResponseEntity.ok(updateCategory);
            
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
       categoryService.deleteById(id);
       return ResponseEntity.noContent().build();
    }
}
