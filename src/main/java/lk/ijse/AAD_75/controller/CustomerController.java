package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.CustomerDTO;
import lk.ijse.AAD_75.entity.Customer;
import lk.ijse.AAD_75.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;

@RestController
@RequestMapping(value = "v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse addCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.addCustomer(customerDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getCustomerDetails(@PathVariable long customer_id){

        CustomerDTO customerDetails = customerService.getCustomerDetails(customer_id);
        return new CommonResponse(OPERATION_SUCCESS, customerDetails, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterCustomers(
            @RequestParam(value = "customer_name", required = false) String customer_name){

        List<CustomerDTO> customerDetails = customerService.filterCustomers(customer_name);
        return new CommonResponse(OPERATION_SUCCESS, customerDetails, SUCCESS_MESSAGE);
    }
}
