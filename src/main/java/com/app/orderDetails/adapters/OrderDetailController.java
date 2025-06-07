package com.app.orderDetails.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.orderDetails.domain.IOrderDetailService;
import com.app.orderDetails.domain.OrderDetail;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    public OrderDetailController(IOrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    // Obtener todos los detalles de pedidos
    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        return orderDetails.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(orderDetails);
    }

    // Obtener un detalle de pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        OrderDetail orderDetail = orderDetailService.findById(id);
        return ResponseEntity.ok(orderDetail);
    }

    // Crear un nuevo detalle de pedido
    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail newOrderDetail = orderDetailService.save(orderDetail);
        return ResponseEntity.status(201).body(newOrderDetail);
    }

    // Actualizar un detalle de pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        OrderDetail updatedOrderDetail = orderDetailService.update(orderDetail, id);
        return ResponseEntity.ok(updatedOrderDetail);
    }

    // Eliminar un detalle de pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
