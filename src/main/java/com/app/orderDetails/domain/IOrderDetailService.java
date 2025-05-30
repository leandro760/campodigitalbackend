package com.app.orderDetails.domain;

import java.util.List;


public interface IOrderDetailService {
    
    List<OrderDetail> findAll();

    OrderDetail findById(Long id);

   OrderDetail save(OrderDetail Order);

    OrderDetail update(OrderDetail Order, Long id);

    void deleteById(Long id);
}
