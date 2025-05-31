package com.app.orders.infrastructure;

public class OrderDto {
    private Long id;
    private String OrderNumber;

    // Empty constructor
    public OrderDto() {
    }

    // Constructor with parameters
    public OrderDto(Long id, String orderNumber) {
        this.id = id;
        this.OrderNumber = orderNumber;
        
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.OrderNumber = orderNumber;
    }

    // toString() method
    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", name='" + OrderNumber + '\'' +
                '}';
    }
}
