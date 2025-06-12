package com.app.orders.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Integer id;

    @Column(name = "OrderDate")
    private LocalDateTime orderDate;

    @Column(name = "OrderNumber", nullable = false)
    private Integer orderNumber;

    @Column(name = "ShippingDate", nullable = false)
    private LocalDateTime shippingDate;

    @Column(name = "DeliveryDate", nullable = false)
    private LocalDateTime deliveryDate;

    @Column(name = "OrderValue", nullable = false)
    private Double orderValue;

    @Column(name = "orderDetail", nullable = false)
    private String orderDetail;

    // Constructor vacío (requerido por JPA)
    public Order() {}

    // Constructor con parámetros
    public Order(Integer id, LocalDateTime orderDate, Integer orderNumber, LocalDateTime shippingDate,
                 LocalDateTime deliveryDate, Double orderValue, String orderDetail) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
        this.orderValue = orderValue;
        this.orderDetail = orderDetail;
    }

    // Métodos getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }
}
