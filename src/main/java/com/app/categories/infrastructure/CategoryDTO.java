package com.app.categories.infrastructure;

public class CategoryDTO {
    private Long id;
    private String name;
    

    // Empty constructor
    public CategoryDTO() {
    }

    // Constructor with parameters
    public CategoryDTO(Long id, String name) {
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
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +                
                '}';
    }
}
