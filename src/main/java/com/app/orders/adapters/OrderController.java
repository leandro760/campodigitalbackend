package com.app.orders.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.orders.domain.IOrderService;
import com.app.orders.domain.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    // Obtener todas las órdenes
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return orders.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(orders);
    }

    // Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    // Crear una nueva orden
    @PostMapping
    public ResponseEntity<Order> creat(@RequestBody Order order) {
        Order newOrder = orderService.save(order);
        return ResponseEntity.status(201).body(newOrder);
    }

    // Actualizar una orden existente
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.update(order, id);
        return ResponseEntity.ok(updatedOrder);
    }

    // Eliminar una orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

