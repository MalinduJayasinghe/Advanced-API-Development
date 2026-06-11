package lk.ijse.AAD_75.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private long order_id;
    private double total;
    private LocalDateTime order_date;

    private long customer_id;

    public OrderDTO(Long orderId, double total, LocalDateTime orderDate) {
    }
}

