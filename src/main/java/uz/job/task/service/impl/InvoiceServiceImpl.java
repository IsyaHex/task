package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.constant.StatusEnum;
import uz.job.task.entity.Invoice;
import uz.job.task.repository.InvoiceRepository;
import uz.job.task.service.InvoiceService;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Optional<Invoice> selectInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if(invoice.isEmpty()) {
            try {
                throw new NoSuchObjectException("Invoice does not exist! Status: " + StatusEnum.FAILED.name());
            } catch (NoSuchObjectException e) {
                e.printStackTrace();
            }
        }
        return invoiceRepository.findById(id);
    }

    @Override
    public List<Invoice> selectAllInvoice() {
        return invoiceRepository.findAll();
    }

    // Criteria 1
    @Override
    public List<Invoice> expired_invoices() {
        return invoiceRepository.findAll().stream()
                .filter(invoice -> invoice.getIssued().isAfter(invoice.getDue())).collect(Collectors.toList());
    }

    // Criteria 2
    @Override
    public List<Invoice> wrong_date_invoices() {
        return invoiceRepository.findAll().stream()
                .filter(invoice -> invoice.getIssued().isBefore(invoice.getOrder().getDate()))
                .collect(Collectors.toList());
    }

}
