package com.app.documentTypes.infrastructure; 

public class DocumentTypeDto {
    private Long id;
    private String name;

    // Empty constructor
    public DocumentTypeDto() {
    }

    // Constructor with parameters
    public DocumentTypeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    // toString() method
    @Override
    public String toString() {
        return "DocumentTypeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
