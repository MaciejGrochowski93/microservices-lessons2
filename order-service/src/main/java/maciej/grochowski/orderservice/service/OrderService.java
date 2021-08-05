package maciej.grochowski.orderservice.service;

import lombok.AllArgsConstructor;
import maciej.grochowski.orderservice.entity.Order;
import maciej.grochowski.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order bookOrder(Order order) {
        return orderRepository.save(order);
    }
}
