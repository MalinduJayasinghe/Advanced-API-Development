package lk.ijse.AAD_75.repository;

import lk.ijse.AAD_75.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "SELECT * FROM Order WHERE order_date = ?1", nativeQuery = true)
    List<Order> filterOrders(LocalDateTime order_date);
}
