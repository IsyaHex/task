package uz.job.task.service;

import uz.job.task.dto.PaymentSaveDto;
import uz.job.task.entity.Payment;

import java.util.Optional;

public interface PaymentService {
    Optional<Payment> selectPaymentById(Long id);
    Payment insertPayment(PaymentSaveDto model);

    // Criteria 6
    Payment overpaid_invoices(Long id);
}
