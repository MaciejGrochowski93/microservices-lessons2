package maciej.grochowski.paymentservice.service;

import lombok.AllArgsConstructor;
import maciej.grochowski.paymentservice.entity.Payment;
import maciej.grochowski.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
