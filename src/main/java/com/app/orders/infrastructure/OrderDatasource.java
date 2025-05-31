package com.app.orders.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.orders.domain.IOrderRepository;
import com.app.orders.domain.Order;

@Component
public class OrderDatasource {

    private final IOrderRepository orderRepository;

    public OrderDatasource(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> update(Order order, Long id) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setOrderNumber(order.getOrderNumber());
            return orderRepository.save(existingOrder);
        });
    }

    public boolean deleteById(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
