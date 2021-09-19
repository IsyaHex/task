package uz.job.task.service.impl;

import javassist.NotFoundException;
import liquibase.pro.packaged.O;
import org.springframework.stereotype.Service;
import uz.job.task.constant.Status;
import uz.job.task.dto.OrderSaveDto;
import uz.job.task.entity.Detail;
import uz.job.task.entity.Invoice;
import uz.job.task.entity.Order;
import uz.job.task.repository.DetailRepository;
import uz.job.task.repository.InvoiceRepository;
import uz.job.task.repository.OrderRepository;
import uz.job.task.service.OrderService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DetailRepository detailRepository;
    private final InvoiceRepository invoiceRepository;
    private static final Integer randUpperBound = 24;

    public OrderServiceImpl(OrderRepository orderRepository, DetailRepository detailRepository, InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.detailRepository = detailRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Order> selectAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> selectOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    @Override
    public Order insertOrder(OrderSaveDto model) {
        Order order = new Order();
        addOrder(model, order);
        return orderRepository.save(order);
    }

    private void changeStatus(Order order) {
        Invoice invoice = invoiceRepository.findById(order.getId())
                        .orElse(null);
        if (invoice != null) {
            invoice.setStatus(Status.FAILED.name());
        }
        else {
            throw new NoSuchElementException();
        }
    }

    private void addOrder(OrderSaveDto model, Order order) {
        Detail detail = new Detail();
        order.setDate(ZonedDateTime.now());
        order.setCustomer(model.getCustomer());
        detail.setOrder(order);
        detail.setProduct(model.getProduct());
        detail.setQuantity(model.getQuantity());
        order.setProductName(detail.getProduct().getName());
        detailRepository.save(detail);
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setStatus(Status.SUCCESS.name());
        invoice.setAmount(Math.random()*100);
        invoice.setIssued(ZonedDateTime.now());
        invoice.setDue(ZonedDateTime.now().plusHours((new Random().nextInt(randUpperBound))));
        invoiceRepository.save(invoice);
    }

}