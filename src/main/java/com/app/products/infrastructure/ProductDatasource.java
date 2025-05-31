package com.app.products.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.products.domain.IProductRepository;
import com.app.products.domain.Product;

@Component
public class ProductDatasource {

    private final IProductRepository productRepository;

    public ProductDatasource(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(Product product, Long id) {
        return productRepository.findById(id).map(existingproduct -> {
            existingproduct.setName(product.getName());
            existingproduct.setDescription(product.getDescription());
            existingproduct.setPrice(product.getPrice());
            return productRepository.save(existingproduct);
        });
    }

    public boolean deleteById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
