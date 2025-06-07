package com.app.documentTypes.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.documentTypes.domain.DocumentType;
import com.app.documentTypes.domain.IDocumentTypeRepository;
import com.app.documentTypes.domain.IDocumentTypeService;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class DocumentTypeService implements IDocumentTypeService {

    private final IDocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentType findById(Long id) {
        Optional<DocumentType> documentType = documentTypeRepository.findById(id);
        return documentType.orElseThrow(() -> new ResourceNotFoundException("DocumentType not found with ID: " + id));
    }

    @Override
    @Transactional
    public DocumentType save(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    @Override
    @Transactional
    public DocumentType update(DocumentType documentType, Long id) {
        DocumentType existingDocumentType = findById(id);
        existingDocumentType.setName(documentType.getName());
        return documentTypeRepository.save(existingDocumentType);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        DocumentType documentType = findById(id);
        documentTypeRepository.delete(documentType);
    }
}

