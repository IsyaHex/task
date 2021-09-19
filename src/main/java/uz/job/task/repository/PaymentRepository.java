package uz.job.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.job.task.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
