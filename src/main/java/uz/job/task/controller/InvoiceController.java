package uz.job.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.job.task.constant.Status;
import uz.job.task.entity.Invoice;
import uz.job.task.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/list")
    public List<Invoice> getAllInvoice() {
        return invoiceService.selectAllInvoice();
    }

    @GetMapping("{id}")
    public Invoice getByInvoiceId(@PathVariable("id") Long id) {
        return invoiceService.selectInvoiceById(id)
                .orElse(null);
    }
}
