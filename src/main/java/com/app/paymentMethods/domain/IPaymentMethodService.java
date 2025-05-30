package com.app.paymentMethods.domain;

import java.util.List;


public interface IPaymentMethodService {
    
    List<PaymentMethod> findAll();

    PaymentMethod findById(Long id);

    PaymentMethod save(PaymentMethod paymentMethod);

    PaymentMethod update (PaymentMethod paymentMethod, Long id);

    void deleteById(Long id);
}
