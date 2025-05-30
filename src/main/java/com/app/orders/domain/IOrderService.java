package com.app.orders.domain;

import java.util.List;


public interface IOrderService {
    
    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    Order update(Order order, Long id);

    void deleteById(Long id);
}
