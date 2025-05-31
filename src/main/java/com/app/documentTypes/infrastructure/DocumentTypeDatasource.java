package com.app.documentTypes.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.documentTypes.domain.IDocumentTypeRepository;
import com.app.documentTypes.domain.DocumentType;

@Component
public class DocumentTypeDatasource {

    private final IDocumentTypeRepository documentTypeRepository;

    public DocumentTypeDatasource(IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }
    public Optional<DocumentType> findById(Long id) {
        return documentTypeRepository.findById(id);
    }

    public DocumentType save(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public Optional<DocumentType> update(DocumentType documentType, Long id) {
        return documentTypeRepository.findById(id).map(existingDocumentType -> {
            existingDocumentType.setName(documentType.getName());
            return documentTypeRepository.save(existingDocumentType);
        });
    }

    public boolean deleteById(Long id) {
        if (documentTypeRepository.existsById(id)) {
            documentTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
