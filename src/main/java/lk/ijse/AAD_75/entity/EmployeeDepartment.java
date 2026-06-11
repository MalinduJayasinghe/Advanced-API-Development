package lk.ijse.AAD_75.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeDepartmentId;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Department department;
}
