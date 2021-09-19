package uz.job.task.controller;

import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.job.task.dto.OrderSaveDto;
import uz.job.task.entity.Invoice;
import uz.job.task.entity.Order;
import uz.job.task.service.CustomerService;
import uz.job.task.service.OrderService;
import uz.job.task.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final InvoiceController invoiceController;

    private static final String invoiceDetailsUrl = "localhost:1111/invoice";
    private static final String baseUrl = "localhost:1111/order";

    public OrderController(OrderService orderService, CustomerService customerService, ProductService productService, InvoiceController invoiceController) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
        this.invoiceController = invoiceController;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("customer", customerService.selectAllCustomer());
        model.addAttribute("product", productService.selectAllProduct());
        return "redirect:" + baseUrl;
    }

    @GetMapping("/list")
    public List<Order> getAllOrder() {
        return orderService.selectAllOrder();
    }


    @GetMapping("{id}")
    public Order getOrderById(@PathVariable("id") Long id) {
        return orderService.selectOrderById(id)
                .orElse(null);
    }

    @PostMapping("/add/{id}")
    public Invoice addOrder(@Valid @NonNull @RequestBody OrderSaveDto order, @PathVariable("id") Long id) {
        orderService.insertOrder(order);
        return invoiceController.getByInvoiceId(id);
    }

//    @PostMapping
//    public String addOrder(@RequestBody @NonNull OrderSaveDto order, @PathVariable("id") Long id) {
//        orderService.insertOrder(order);
//        orderService.selectOrderById(id);
//        return "redirect:" + invoiceDetails + "/{id}";
//    }

}
