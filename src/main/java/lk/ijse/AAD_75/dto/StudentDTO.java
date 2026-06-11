package lk.ijse.AAD_75.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long student_id;
    private String student_fname;
    private String student_lastname;
    private String student_contact;

    private long school_id;
}
