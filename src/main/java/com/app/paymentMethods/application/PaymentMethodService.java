package com.app.paymentMethods.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.paymentMethods.domain.PaymentMethod;
import com.app.paymentMethods.domain.IPaymentMethodRepository;
import com.app.paymentMethods.domain.IPaymentMethodService;
import com.app.shared.adapters.exception.ResourceNotFoundException;

@Service
public class PaymentMethodService implements IPaymentMethodService {

    private final IPaymentMethodRepository paymentMethodRepository;

    public PaymentMethodService(IPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod findById(Long id) {
        return paymentMethodRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("PaymentMethod not found with ID: " + id));
    }

    @Override
    @Transactional
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    @Transactional
    public PaymentMethod update(PaymentMethod paymentMethod, Long id) {
        PaymentMethod existingPaymentMethod = findById(id);
        existingPaymentMethod.setName(paymentMethod.getName());
        return paymentMethodRepository.save(existingPaymentMethod);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        PaymentMethod paymentMethod = findById(id);
        paymentMethodRepository.delete(paymentMethod);
    }
}
