package uz.job.task.service.impl;

import org.springframework.stereotype.Service;
import uz.job.task.entity.Customer;
import uz.job.task.repository.CustomerRepository;
import uz.job.task.service.CustomerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> selectCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.findAll();
    }

    // Criteria 4
    @Override
    public List<Customer> customers_without_orders() {
        LocalTime timeAfter = LocalTime.parse("00:00:00");
        LocalDate dateAfter = LocalDate.parse("2016-01-01");
        LocalTime timeBefore = LocalTime.parse("23:59:59");
        LocalDate dateBefore = LocalDate.parse("2016-12-31");

        // Check provided db scheme, discrepancy in the database structure and the specified search criteria
        // Proper working method

//        return customerRepository.findAll().stream()
//                .filter(customer -> customer.getOrder().getDate()
//                        .isAfter(ZonedDateTime.of(dateAfter,timeAfter, ZoneId.systemDefault())) &&
//                        customer.getOrder().getDate().isBefore(ZonedDateTime.of(dateBefore,timeBefore,ZoneId.systemDefault())))
//                .collect(Collectors.toList());

        return null;
    }

    // TODO ...
    // Criteria 5
    @Override
    public List<Customer> customers_last_orders(Long id) {
//        List<Customer> criteria =  customerRepository.findById(id).stream()
//                .filter(customer -> customer.getOrder()).collect(Collectors.toList());
        return null;
    }

}
