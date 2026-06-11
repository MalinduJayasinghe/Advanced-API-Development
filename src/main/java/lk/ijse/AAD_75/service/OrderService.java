package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.OrderDTO;
import lk.ijse.AAD_75.dto.response.GetOrderDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    void addOrder(OrderDTO orderDTO);
    GetOrderDTO getOrderDetails(long order_id);
    List<OrderDTO> filterOrders(LocalDateTime order_date);
}
