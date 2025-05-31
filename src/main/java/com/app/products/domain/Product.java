package com.app.products.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Integer id;

    @Column(name = "Product", nullable = false, length = 50)
    private String name;

    @Column(name = "Description", nullable = false, length = 100)
    private String description;

    @Column(name = "UnitOfMeasure", nullable = false, length = 50)
    private String unitOfMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId", nullable = false)
    private ECategory category;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private Float price;

    @Column(name = "Count", nullable = false)
    private Integer count;

    // Constructor vacío (requerido por JPA)
    public Product() {}

    // Constructor con parámetros
    public Product(Integer id, String name, String description, String unitOfMeasure, ECategory category, Float price, Integer count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unitOfMeasure = unitOfMeasure;
        this.category = category;
        this.price = price;
        this.count = count;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public Float getPrice() {
    return price;
    }   


    public void setPrice(Float price) {
    this.price = price;
    }

}

 
