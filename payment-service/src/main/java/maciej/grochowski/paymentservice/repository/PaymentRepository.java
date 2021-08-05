package maciej.grochowski.paymentservice.repository;

import maciej.grochowski.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
