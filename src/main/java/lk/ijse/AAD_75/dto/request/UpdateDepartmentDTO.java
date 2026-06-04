package lk.ijse.AAD_75.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartmentDTO {

    private Long department_id;
    private String department_location;
}
