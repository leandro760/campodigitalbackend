package com.app.orderDetails.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.orderDetails.domain.OrderDetail;
import com.app.orderDetails.domain.IOrderDetailRepository;
import com.app.orderDetails.domain.IOrderDetailService;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class OrderDetailService implements IOrderDetailService {

    private final IOrderDetailRepository orderDetailRepository;

    public OrderDetailService(IOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail findById(Long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderDetail not found with ID: " + id));
    }

    @Override
    @Transactional
    public OrderDetail save(OrderDetail orderDetail) {
        // Si quieres alguna validación especial para OrderDetail la puedes agregar aquí
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    @Transactional
    public OrderDetail update(OrderDetail orderDetail, Long id) {
        OrderDetail existingOrderDetail = findById(id);
        
        existingOrderDetail.setPaymentMethod(orderDetail.getPaymentMethod());
        existingOrderDetail.setQuantity(orderDetail.getQuantity());
        existingOrderDetail.setSalePrice(orderDetail.getSalePrice());  // o setSalePrice si usas ese nombre
        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        OrderDetail orderDetail = findById(id);
        orderDetailRepository.delete(orderDetail);
    }
}
