package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lk.ijse.AAD_75.enumeration.EmployeeStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

// Entity classes must all be encapsulated
//@Data - loads Getters, Setters, toString and Equals for the relevant entity, not normally used

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    private long employeeId;

    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime joinedDate;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<EmployeeDepartment> employeeDepartmentList;
}
