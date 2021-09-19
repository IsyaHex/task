package uz.job.task.service;

import uz.job.task.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    Optional<Invoice> selectInvoiceById(Long id);
    List<Invoice> selectAllInvoice();
}
