package maciej.grochowski.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    // remove Entity, Table, Id, GeneratedValue, because in this project it's a DTO, not Entity

    private int paymentId;
    private String paymentStatus; // success/failure
    private String transactionId;
    
    private int orderId;
    private int quantity;
}
