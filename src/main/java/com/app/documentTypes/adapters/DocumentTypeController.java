package com.app.documentTypes.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.documentTypes.domain.IDocumentTypeService;
import com.app.documentTypes.domain.DocumentType;

@RestController
@RequestMapping("/api/documentTypes")
public class DocumentTypeController {

    private final IDocumentTypeService documentTypeService;

    public DocumentTypeController(IDocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    // Obtener todos los tipos de documentos
    @GetMapping
    public ResponseEntity<List<DocumentType>> getAllDocumentTypes() {
        List<DocumentType> documentTypes = documentTypeService.findAll();
        return documentTypes.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(documentTypes);
    }

    // Obtener un tipo de documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<DocumentType> getDocumentTypeById(@PathVariable Long id) {
        DocumentType documentType = documentTypeService.findById(id);
        return ResponseEntity.ok(documentType);
    }

    // Crear un nuevo tipo de documento
    @PostMapping
    public ResponseEntity<DocumentType> createDocumentType(@RequestBody DocumentType documentType) {
        DocumentType newDocumentType = documentTypeService.save(documentType);
        return ResponseEntity.status(201).body(newDocumentType);
    }

    // Actualizar un tipo de documento existente
    @PutMapping("/{id}")
    public ResponseEntity<DocumentType> updateDocumentType(@PathVariable Long id, @RequestBody DocumentType documentType) {
        DocumentType updatedDocumentType = documentTypeService.update(documentType, id);
        return ResponseEntity.ok(updatedDocumentType);
    }

    // Eliminar un tipo de documento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumentType(@PathVariable Long id) {
        documentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
