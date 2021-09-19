package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.constant.Status;
import uz.job.task.dto.PaymentSaveDto;
import uz.job.task.entity.Payment;
import uz.job.task.repository.PaymentRepository;
import uz.job.task.service.PaymentService;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Optional<Payment> selectPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment insertPayment(PaymentSaveDto model) {
        Payment payment = new Payment();
        addPayment(model, payment);
        return paymentRepository.save(payment);
    }


    private void addPayment(PaymentSaveDto model, Payment payment) {
        payment.setInvoice(model.getInvoice());
        payment.setAmount(model.getInvoice().getAmount());
        payment.setTime(ZonedDateTime.now());
        payment.setStatus(model.getInvoice().getStatus());
    }

//    private void addPaymentJson(PaymentSaveDto model, Payment payment) {
//        payment.setInvoice(model.getInvoice());
//        payment.setAmount(Math.random()*100);
//        payment.setTime(ZonedDateTime.now());
//        payment.setStatus(Status.SUCCESS.name());
//    }

}
