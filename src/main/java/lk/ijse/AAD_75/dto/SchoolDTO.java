package lk.ijse.AAD_75.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {

    private Long school_id;
    private String school_name;
    private String school_location;
}
