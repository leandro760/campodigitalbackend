package com.app.orderDetails.infrastructure;

public class OrderDetailDTO {

    private Long id;
    private String product;
    private int quantity;
    private float salePrice;
    private String paymentMethod;
    private int order;

    // Constructor vacío
    public OrderDetailDTO() {
    }

    // Constructor con parámetros
    public OrderDetailDTO(Long id, String product, int quantity, float salePrice, String paymentMethod, int order) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.paymentMethod = paymentMethod;
        this.order = order;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    

    @Override
public String toString() {
    return "{" +
            "\"id\": " + id + "," +
            "\"product\": \"" + product + "\"," +
            "\"quantity\": " + quantity + "," +
            "\"salePrice\": " + salePrice + "," +
            "\"paymentMethod\": \"" + paymentMethod + "\"," +
            "\"order\": " + order +
            "}";
}

}
