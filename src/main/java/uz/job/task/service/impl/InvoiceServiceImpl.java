package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.constant.Status;
import uz.job.task.entity.Invoice;
import uz.job.task.repository.InvoiceRepository;
import uz.job.task.service.InvoiceService;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
                throw new NoSuchObjectException("Invoice does not exist! Status: " + Status.FAILED.name());
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
}
