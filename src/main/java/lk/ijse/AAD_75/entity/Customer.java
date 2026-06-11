package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    private String customer_name;
    private String customer_address;

    @OneToMany(mappedBy = "customer",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Order> orders;
}
