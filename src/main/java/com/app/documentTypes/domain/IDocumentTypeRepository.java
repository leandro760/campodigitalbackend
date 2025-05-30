package com.app.documentTypes.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentTypeRepository  extends JpaRepository<DocumentType, Long>  {
    

    // Get all documentTypes (already provided by JpaRepository)
    @Override
    @NonNull
    List<DocumentType> findAll();

    // Search DocumentType by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<DocumentType> findById(@NonNull Long id);

    // Save a DocumentType (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends DocumentType> S save(@NonNull S documentType);

    // Check if a DocumentType with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete DocumentType by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a Category by their email
    //Optional<Category> findByEmail(String email);

    // Check if an email is already registered
    //boolean existsByEmail(String email);
}