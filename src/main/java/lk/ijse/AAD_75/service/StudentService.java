package lk.ijse.AAD_75.service;


import lk.ijse.AAD_75.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    void saveStudent(StudentDTO studentDTO) throws Exception;
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentDetails(long student_id);
}
