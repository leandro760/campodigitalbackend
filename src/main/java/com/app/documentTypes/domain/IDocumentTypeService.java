package com.app.documentTypes.domain;

import java.util.List;


public interface IDocumentTypeService {
    
    List<DocumentType> findAll();

    DocumentType findById(Long id);

    DocumentType save(DocumentType documentType);

    DocumentType update(DocumentType documentType, Long id);

    void deleteById(Long id);
}
