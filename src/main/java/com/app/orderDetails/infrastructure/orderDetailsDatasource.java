package com.app.orderDetails.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import com.app.orderDetails.domain.IOrderDetailRepository;
import com.app.orderDetails.domain.OrderDetail;


@Component
public class orderDetailsDatasource {

    private final IOrderDetailRepository orderDetailRepository;

    public orderDetailsDatasource(IOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public Optional<OrderDetail> update(OrderDetail newData, Long id) {
        return orderDetailRepository.findById(id).map(existingOrderDetail -> {
            existingOrderDetail.setProduct(newData.getProduct());
           
            existingOrderDetail.setPaymentMethod(newData.getPaymentMethod());
            existingOrderDetail.setQuantity(newData.getQuantity());
            existingOrderDetail.setSalePrice(newData.getSalePrice());            
            return orderDetailRepository.save(existingOrderDetail);
        });
    }

    public boolean deleteById(Long id) {
        if (orderDetailRepository.existsById(id)) {
            orderDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
