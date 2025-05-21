package com.hms.billing_and_payment_service.repositories;

import com.hms.billing_and_payment_service.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
