package com.app.products.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.products.domain.Product;
import com.app.products.domain.IProductRepository;
import com.app.products.domain.IProductService;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(Product product, Long id) {
        Product existingProduct = findById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}
