package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String userName;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAccount userAccount;
}


