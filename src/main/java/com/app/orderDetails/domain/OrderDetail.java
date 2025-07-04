package com.app.orderDetails.domain;

import com.app.paymentMethods.domain.PaymentMethod;


import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailId")
    private Integer id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "SalePrice", nullable = false)
    private Double salePrice;

    @Column(name = "SubTotal", nullable = false)
    private Double subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PaymentMethodId", nullable = false)
    private PaymentMethod paymentMethod;


    // Constructor vacío (requerido por JPA)
    public OrderDetail() {}

    // Constructor con parámetros
    public OrderDetail(Integer id, Integer quantity, Double salePrice, Double subTotal,
                       PaymentMethod paymentMethod) {
        this.id = id;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.subTotal = subTotal;
        this.paymentMethod = paymentMethod;
        
    }

    // Métodos getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

 
   
}
