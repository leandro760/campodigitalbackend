package com.app.paymentMethods.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.paymentMethods.domain.IPaymentMethodRepository;
import com.app.paymentMethods.domain.PaymentMethod;

@Component
public class PaymentMethodDatasource {

    private final IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethodDatasource(IPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }
    public Optional<PaymentMethod> findById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public Optional<PaymentMethod> update(PaymentMethod paymentMethod, Long id) {
        return paymentMethodRepository.findById(id).map(existingpaymentMethod -> {
            existingpaymentMethod.setName(paymentMethod.getName());
            return paymentMethodRepository.save(existingpaymentMethod);
        });
    }

    public boolean deleteById(Long id) {
        if (paymentMethodRepository.existsById(id)) {
            paymentMethodRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
