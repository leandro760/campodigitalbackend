package com.app.products.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository  extends JpaRepository<Product, Long>  {
    

    // Get all Product (already provided by JpaRepository)
    @Override
    @NonNull
    List<Product> findAll();

    // Search Product by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Product> findById(@NonNull Long id);

    // Save a Product (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Product> S save(@NonNull S product);

    // Check if a Productwith a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete Product by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}