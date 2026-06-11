package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {

    @Id
    private Long department_id;
    private String department_name;
    private String department_location;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<EmployeeDepartment> employeeDepartmentList;
}
