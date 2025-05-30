package com.app.orderDetails.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository  extends JpaRepository<OrderDetail, Long>  {
    

    // Get all OrderDetail (already provided by JpaRepository)
    @Override
    @NonNull
    List<OrderDetail> findAll();

    // Search OrderDetail by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<OrderDetail> findById(@NonNull Long id);

    // Save a OrderDetail(already provided by JpaRepository)
    @Override
    @NonNull
    <S extends OrderDetail> S save(@NonNull S orderDetail);

    // Check if a OrderDetail with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete OrderDetail by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}