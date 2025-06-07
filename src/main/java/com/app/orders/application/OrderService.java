package com.app.orders.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.orders.domain.IOrderRepository;
import com.app.orders.domain.IOrderService;
import com.app.orders.domain.Order;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
    }

    @Override
    @Transactional
    public Order save(Order order) {
        // Validaciones si es necesario
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order update(Order order, Long id) {
        Order existingOrder = findById(id);
        existingOrder.setOrderNumber(order.getOrderNumber());
        return orderRepository.save(existingOrder);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Order order = findById(id);
        orderRepository.delete(order);
    }
}
