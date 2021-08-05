package maciej.grochowski.orderservice.controller;

import lombok.AllArgsConstructor;
import maciej.grochowski.orderservice.entity.Order;
import maciej.grochowski.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/bookOrder")
    public Order bookOrder(@RequestBody Order order) {
        return orderService.bookOrder(order);
    }
}
