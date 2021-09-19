package uz.job.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.job.task.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
