package maciej.grochowski.orderservice.service;

import lombok.AllArgsConstructor;
import maciej.grochowski.orderservice.common.Payment;
import maciej.grochowski.orderservice.common.TransactionRequest;
import maciej.grochowski.orderservice.common.TransactionResponse;
import maciej.grochowski.orderservice.entity.Order;
import maciej.grochowski.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    private final RestTemplate restTemplate;

    public TransactionResponse bookOrder(TransactionRequest request) {
        String message = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();

        payment.setOrderId(order.getOrderId());
        payment.setQuantity(order.getQuantity());

        // returns the real object
        Payment paymentResponse = restTemplate.postForObject("http://localhost:8082/payment/addPayment", payment, Payment.class);

        orderRepository.save(order);

        message = paymentResponse.getPaymentStatus().equals("success") ? "Payment successful, order placed" : "Payment failed, order added to cart";

        return new TransactionResponse(order, paymentResponse.getTransactionId(), payment.getQuantity(), message);
    }
}
