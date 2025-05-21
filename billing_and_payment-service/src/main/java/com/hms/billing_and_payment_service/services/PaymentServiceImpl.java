package com.hms.billing_and_payment_service.services;

import com.hms.billing_and_payment_service.entities.Payment;
import com.hms.billing_and_payment_service.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public Payment makePayment(Payment payment) {
        payment.setPaymentDate(java.time.LocalDateTime.now());
        payment.setPaymentStatus(true); // For now, default it to true
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
