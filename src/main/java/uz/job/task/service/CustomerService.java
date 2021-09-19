package uz.job.task.service;

import uz.job.task.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCustomer();
}
