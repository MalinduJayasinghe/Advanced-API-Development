package lk.ijse.AAD_75.repository;

import lk.ijse.AAD_75.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT * FROM Customer WHERE customer_name LIKE %1?", nativeQuery = true)
    List<Customer> filterCustomers(String customerName);
}
