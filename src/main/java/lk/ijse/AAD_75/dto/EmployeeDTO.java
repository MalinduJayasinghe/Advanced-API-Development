package lk.ijse.AAD_75.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private long employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDateTime joinedDate;

}
