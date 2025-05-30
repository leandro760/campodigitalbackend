package com.app.paymentMethods.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodRepository  extends JpaRepository<PaymentMethod, Long>  {
    

    // Get all PaymentMethods (already provided by JpaRepository)
    @Override
    @NonNull
    List<PaymentMethod> findAll();

    // Search PaymentMethodby ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<PaymentMethod> findById(@NonNull Long id);

    // Save a PaymentMethod (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends PaymentMethod> S save(@NonNull S paymentMethod);

    // Check if a PaymentMethodwith a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete PaymentMethod by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}