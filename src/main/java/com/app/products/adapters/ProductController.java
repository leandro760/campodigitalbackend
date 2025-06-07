package com.app.products.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.products.domain.IProductService;
import com.app.products.domain.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return products.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(products);
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return ResponseEntity.status(201).body(newProduct);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.update(product, id);
        return ResponseEntity.ok(updatedProduct);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
          productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

