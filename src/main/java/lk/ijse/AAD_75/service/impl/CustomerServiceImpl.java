package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.CustomerDTO;
import lk.ijse.AAD_75.entity.Customer;
import lk.ijse.AAD_75.entity.Department;
import lk.ijse.AAD_75.repository.CustomerRepository;
import lk.ijse.AAD_75.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {

        log.info("execute method addCustomer");

        try {

            Customer customer = new Customer();
            customer.setCustomer_name(customer.getCustomer_name());
            customer.setCustomer_address(customer.getCustomer_address());

            customerRepository.save(customer);
            log.info("Customer added successfully");

        }catch (Exception e){
            log.info("Error in method addCustomer" + e.getMessage());
        }
    }

    @Override
    public CustomerDTO getCustomerDetails(long customer_id) {

        log.info("execute method getCustomerDetails");

        try {

            Optional<Customer> optionalCustomer = customerRepository.findById(customer_id);

            if (optionalCustomer.isEmpty()) {
                throw new RuntimeException("Customer not found");
            }

            Customer customer = optionalCustomer.get();
            CustomerDTO responseData = new CustomerDTO();

            responseData.setCustomer_id(customer.getCustomer_id());
            responseData.setCustomer_name(customer.getCustomer_name());
            responseData.setCustomer_address(customer.getCustomer_address());
            return responseData;

        }catch (Exception e){
            log.info("Error in method getCustomerDetails" + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CustomerDTO> filterCustomers(String customerName) {

        log.info("execute method filterCustomers");

        try {

            List<CustomerDTO> responseList = new ArrayList<>();
            List<Customer> customers = customerRepository.filterCustomers(customerName);

            for (Customer customer : customers) {

                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomer_id(),
                        customer.getCustomer_name(),
                        customer.getCustomer_address()
                );

                responseList.add(customerDTO);
            }

            return responseList;

        }catch (Exception e){
            log.info("Error in method filterCustomers" + e.getMessage());
            throw e;
        }
    }
}
