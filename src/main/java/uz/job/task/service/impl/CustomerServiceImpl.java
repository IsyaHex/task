package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.entity.Customer;
import uz.job.task.repository.CustomerRepository;
import uz.job.task.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.findAll();
    }
}
