package uz.job.task.service;

import uz.job.task.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> selectCustomerById(Long id);
    List<Customer> selectAllCustomer();

    // Criteria 4
    List<Customer> customers_without_orders();
    // Criteria 5
    List<Customer> customers_last_orders(Long id);
}
