package com.app.customers.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private Int idTipoCliente;

    @Column(nullable = false, unique = true)
    private String PrimerNombre;

    @Column(nullable = false)
    private String PrimerApellido;

    @Column(nullable = false)
    private String password;

      @Column(nullable = false)
    private String password;
    
      @Column(nullable = false)
    private String password;

      @Column(nullable = false)
    private String password;

    // Empty constructor (required for JPA)
    public User() {}

    // Constructor with parameters
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}