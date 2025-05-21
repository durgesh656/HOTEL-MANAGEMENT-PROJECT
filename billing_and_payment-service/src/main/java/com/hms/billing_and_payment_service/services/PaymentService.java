package com.hms.billing_and_payment_service.services;

import com.hms.billing_and_payment_service.entities.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PaymentService {
    Payment makePayment(Payment payment);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
    void deletePayment(Long id);
}
