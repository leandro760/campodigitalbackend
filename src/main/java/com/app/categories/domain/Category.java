package com.app.categories.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private Integer id;

    @Column(name = "Category", nullable = false, length = 50)
    private String name;

    // Constructor vacío (requerido por JPA)
    public Category() {}

    // Constructor con parámetros
    public Category(Integer id, String name) {
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

