package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.OrderDTO;
import lk.ijse.AAD_75.dto.response.GetOrderDTO;
import lk.ijse.AAD_75.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;

@RestController
@RequestMapping(value = "v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addOrder(@RequestBody OrderDTO orderDTO) {

        orderService.addOrder(orderDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOrderDetails(@PathVariable long order_id) {

        GetOrderDTO orderDetails = orderService.getOrderDetails(order_id);
        return new CommonResponse(OPERATION_SUCCESS,orderDetails, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterOrders(
            @RequestParam (value = "order_date", required=false) LocalDateTime order_date) {

        List<OrderDTO> orderDetails = orderService.filterOrders(order_date);
        return new CommonResponse(OPERATION_SUCCESS,orderDetails, SUCCESS_MESSAGE);
    }
}
