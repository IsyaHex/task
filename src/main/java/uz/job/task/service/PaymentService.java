package uz.job.task.service;

import uz.job.task.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> selectAllPayment();
    Optional<Payment> selectPaymentById(Long id);
}
