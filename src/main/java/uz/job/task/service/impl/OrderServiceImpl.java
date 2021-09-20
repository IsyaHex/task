package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.constant.CountryEnum;
import uz.job.task.constant.StatusEnum;
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
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    // Criteria 3
    @Override
    public List<Order> orders_without_details() {
        List<Order> list = ordersForSomePeriod();
        return list.stream()
                .filter(order -> order.getDetail() == null).collect(Collectors.toList());
    }

    private List<Order> ordersForSomePeriod() {
        LocalDate localDate = LocalDate.parse("2016-09-06");
        LocalTime localTime = LocalTime.parse("00:00:00");
        return orderRepository.findAll().stream()
                .filter(order -> order.getDate().isBefore(ZonedDateTime.of(localDate,localTime, ZoneId.systemDefault())))
                .collect(Collectors.toList());
    }

    // Criteria 9
    @Override
    public List<Order> number_of_products_in_year() {
        List<Order> list = ordersForSomePeriod();
        return list.stream()
                .filter(order -> order.getCustomer().getCountry() != null).collect(Collectors.toList());
    }

    // Criteria 10
    @Override
    public List<Order> orders_without_invoices() {
        return orderRepository.findAll().stream()
                .filter(order -> order.getDetail() != null &&
                        order.getDetail().getInvoice() == null).collect(Collectors.toList());
    }

    private void changeStatus(Order order) {
        Invoice invoice = invoiceRepository.findById(order.getId())
                        .orElse(null);
        if (invoice == null) {
            throw new NoSuchElementException();
        } else {
            invoice.setStatus(StatusEnum.FAILED.name());
        }
    }

    private void addOrder(OrderSaveDto model, Order order) {
        Detail detail = new Detail();
        detail.setProduct(model.getProduct());
        detail.setQuantity(model.getQuantity());
        order.setDate(ZonedDateTime.now());
        order.setCustomer(model.getCustomer());
        order.setDetail(detail);
        order.setProductName(detail.getProduct().getName());
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setStatus(StatusEnum.SUCCESS.name());
        invoice.setAmount(Math.random()*100);
        invoice.setReimbursed(0);
        invoice.setIssued(ZonedDateTime.now());
        invoice.setDue(ZonedDateTime.now().plusHours((new Random().nextInt(randUpperBound))));
//      Comment the line below to check Criteria 10
        detail.setInvoice(invoice.getId());
        invoiceRepository.save(invoice);
        detailRepository.save(detail);
    }

}