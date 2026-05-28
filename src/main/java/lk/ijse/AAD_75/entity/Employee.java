package lk.ijse.AAD_75.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

// Entity classes must all be encapsulated
//@Data - loads Getters, Setters, toString and Equals for the relevant entity, not normally used

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long employeeId;

    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime joinedDate;
}
