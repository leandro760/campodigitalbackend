package com.app.documentTypes.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "DocumentTypes")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentTypeId")
    private Integer id;

    @Column(name = "DocumentType", length = 20)
    private String name;

    // Constructor vacío (requerido por JPA)
    public DocumentType() {}

    // Constructor con parámetros
    public DocumentType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Métodos getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
