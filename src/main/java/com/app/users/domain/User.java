package com.app.users.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserTypeId", nullable = false)
    private ETypeUser userType;

    @Column(name = "FullName", nullable = false, length = 220)
    private String fullName;

    @Column(name = "Phone", nullable = false)
    private Integer phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DocumentTypeId", nullable = false)
    private ETypeDocument documentType;

    @Column(name = "DocumentNumber", nullable = false)
    private Integer documentNumber;

    @Column(name = "Email", nullable = false, length = 50)
    private String email;

    @Column(name = "BirthDate")
    private LocalDateTime birthDate;

    @Column(name = "RegistrationDate")
    private LocalDateTime registrationDate;

    @Column(name = "Address", nullable = false, length = 100)
    private String address;

    // Empty constructor (required for JPA)
    public User() {}

    // Constructor with parameters
     public User(Integer id, ETypeUser eTypeUser, String fullName, Integer phone, ETypeDocument eTypeDocument,
                Integer documentNumber, String email, LocalDateTime birthDate, LocalDateTime registrationDate,
                String address) {
        this.id = id;
        this.userType = eTypeUser;
        this.fullName = fullName;
        this.phone = phone;
        this.documentType = eTypeDocument;
        this.documentNumber = documentNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.address = address;
    }
    // Getters y Setters
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ETypeUser getETypeUser() {
        return userType;
    }

    public void setETypeUser(ETypeUser userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public ETypeDocument getETypeDocument() {
        return documentType;
    }

    public void setETypeDocument(ETypeDocument documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}