package com.app.orders.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository  extends JpaRepository<Order, Long>  {
    

    // Get all Order(already provided by JpaRepository)
    @Override
    @NonNull
    List<Order> findAll();

    // Search Order by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Order> findById(@NonNull Long id);

    // Save a Order (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Order> S save(@NonNull S order);

    // Check if a Order with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete Order by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}