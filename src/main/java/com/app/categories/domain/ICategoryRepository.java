package com.app.categories.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository  extends JpaRepository<Category, Long>  {
    

    // Get all categories (already provided by JpaRepository)
    @Override
    @NonNull
    List<Category> findAll();

    // Search Category by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Category> findById(@NonNull Long id);

    // Save a Category (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Category> S save(@NonNull S category);

    // Check if a Category with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete Category by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}