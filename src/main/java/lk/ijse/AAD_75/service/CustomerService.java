package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerDetails(long customer_id);
    List<CustomerDTO> filterCustomers(String customerName);

}
