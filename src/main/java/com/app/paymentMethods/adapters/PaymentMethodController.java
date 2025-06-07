package com.app.paymentMethods.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.paymentMethods.domain.IPaymentMethodService;
import com.app.paymentMethods.domain.PaymentMethod;

@RestController
@RequestMapping("/api/paymentMethods")
public class PaymentMethodController {

    private final IPaymentMethodService paymentMethodService;

    public PaymentMethodController(IPaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    // Obtener todos los métodos de pago
    @GetMapping
    public ResponseEntity<List<PaymentMethod>> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodService.findAll();
        return paymentMethods.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(paymentMethods);
    }

    // Obtener un método de pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable Long id) {
        PaymentMethod paymentMethod = paymentMethodService.findById(id);
        return ResponseEntity.ok(paymentMethod);
    }

    // Crear un nuevo método de pago
    @PostMapping
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod newPaymentMethod = paymentMethodService.save(paymentMethod);
        return ResponseEntity.status(201).body(newPaymentMethod);
    }

    // Actualizar un método de pago existente
    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod updatedPaymentMethod = paymentMethodService.update(paymentMethod, id);
        return ResponseEntity.ok(updatedPaymentMethod);
    }

    // Eliminar un método de pago por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
