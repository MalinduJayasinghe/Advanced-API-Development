package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.OrderDTO;
import lk.ijse.AAD_75.dto.response.GetOrderDTO;
import lk.ijse.AAD_75.entity.Customer;
import lk.ijse.AAD_75.entity.Order;
import lk.ijse.AAD_75.repository.CustomerRepository;
import lk.ijse.AAD_75.repository.OrderRepository;
import lk.ijse.AAD_75.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void addOrder(OrderDTO orderDTO) {

        log.info("execute method addOrder");

        try {

            Order order = new Order();
            order.setOrder_date(order.getOrder_date());
            order.setTotal(order.getTotal());

            Optional <Customer> optionalCustomer = customerRepository.findById(orderDTO.getCustomer_id());

            if (optionalCustomer.isEmpty()) {
                throw new RuntimeException("Customer not found");
            }

            orderRepository.save(order);
            log.info("Order added successfully");

        }catch (Exception e){
            log.info("Error in method addOrder");
        }

    }

    @Override
    public GetOrderDTO getOrderDetails(long order_id) {

        log.info("execute method getOrderDetails");

        try {

            Optional<Order> optionalOrder = orderRepository.findById(order_id);

            if(optionalOrder.isEmpty()){
                throw new RuntimeException("Order not found");
            }

            Order order = optionalOrder.get();

            GetOrderDTO responseData = new GetOrderDTO();
            responseData.setOrderId(order.getOrder_id());
            responseData.setOrderDate(order.getOrder_date());
            responseData.setTotal(order.getTotal());

            Customer customer = order.getCustomer();

            responseData.setCustomerId(customer.getCustomer_id());
            responseData.setCustomerName(customer.getCustomer_name());

            return responseData;

        }catch (Exception e){
            log.info("Error in method getOrderDetails");
            throw e;
        }
    }

    @Override
    public List<OrderDTO> filterOrders(LocalDateTime order_date) {

        log.info("execute method filterOrders");

        try {

            List<OrderDTO> responseList = new ArrayList<>();
            List<Order> orders = orderRepository.filterOrders(order_date);

            for (Order order : orders) {

                OrderDTO orderDTO = new OrderDTO(
                        order.getOrder_id(),
                        order.getTotal(),
                        order.getOrder_date()
                );

                responseList.add(orderDTO);
            }

            return responseList;

        }catch (Exception e){
            log.info("Error in method filterOrders");
            throw e;
        }
    }
}
