package maciej.grochowski.orderservice.repository;

import maciej.grochowski.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Integer>{
}
