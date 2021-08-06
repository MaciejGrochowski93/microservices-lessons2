package maciej.grochowski.paymentservice.service;

import lombok.AllArgsConstructor;
import maciej.grochowski.paymentservice.entity.Payment;
import maciej.grochowski.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
        payment.setPaymentStatus(didPaymentSucceed());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String didPaymentSucceed() {
        // should be 3rd party gateway (like paypal)
        return new Random().nextBoolean() ? "success" : "failure";
    }
}
