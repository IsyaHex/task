package uz.job.task.controller;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import uz.job.task.dto.OrderSaveDto;
import uz.job.task.dto.PaymentSaveDto;
import uz.job.task.entity.Payment;
import uz.job.task.service.PaymentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/list")
    public List<Payment> getAllPayment() {
        return paymentService.selectAllPayment();
    }

    @GetMapping("{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        return paymentService.selectPaymentById(id)
                .orElse(null);
    }

    @PostMapping("/add/{id}")
    public Payment addPayment(@Valid @NonNull @RequestBody PaymentSaveDto payment, @PathVariable("id") Long id) {
        paymentService.i;
        return paymentService.selectPaymentById(id)
                .orElse(null);
    }
}
