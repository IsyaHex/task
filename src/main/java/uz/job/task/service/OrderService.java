package uz.job.task.service;

import uz.job.task.dto.OrderSaveDto;
import uz.job.task.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order insertOrder(OrderSaveDto model);
    Optional<Order> selectOrderById(Long id);
    List<Order> selectAllOrder();

    // Criteria 3
    List<Order> orders_without_details();
    // Criteria 9
    List<Order> number_of_products_in_year();
    // Criteria 10
    List<Order> orders_without_invoices();
}
