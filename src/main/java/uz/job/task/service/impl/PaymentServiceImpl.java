package uz.job.task.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uz.job.task.constant.StatusEnum;
import uz.job.task.dto.PaymentSaveDto;
import uz.job.task.entity.Invoice;
import uz.job.task.entity.Payment;
import uz.job.task.repository.InvoiceRepository;
import uz.job.task.repository.PaymentRepository;
import uz.job.task.service.PaymentService;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, InvoiceRepository invoiceRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
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

    private Specification<Payment> filterByInvoiceId(Long id) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("inv_id"), id));
    }

    private List<Payment> findAllByInvoiceId(Long id) {
        return paymentRepository.findAll(filterByInvoiceId(id));
    }

    //TODO ...
    // Criteria 6
    @Override
    public Payment overpaid_invoices(Long id) {
//        Stream<Payment> numbers = paymentRepository.findAll(filterByInvoiceId(id)).stream()
//                .reduce((x, y) -> {
//                    if(y.getInvoice().getAmount() < y.getAmount())
//                        return y.getInvoice().setReimbursed(y.getInvoice().getAmount() - (x + y.getAmount()));
//                });
//
//        return paymentRepository.findById(id).stream()
//                .reduce()
//                .map(payment -> payment.getInvoice()
//                        .setReimbursed(payment.getInvoice().getAmount() - numbers.reduce((x,y)-> x+y))
//
//        Invoice inv = invoiceRepository.findById(id).stream()
//                .map(invoice -> invoice.setReimbursed(invoice.getReimbursed() - invoice.get
//                        paymentRepository.findById(id).get().getAmount())).
        return null;
    }


}
