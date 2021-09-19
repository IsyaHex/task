package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.entity.Payment;
import uz.job.task.repository.PaymentRepository;
import uz.job.task.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> selectAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> selectPaymentById(Long id) {
        return paymentRepository.findById(id);
    }


    private void addPayment() {


    }
}
