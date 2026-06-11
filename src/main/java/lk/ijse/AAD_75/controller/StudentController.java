package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.StudentDTO;
import lk.ijse.AAD_75.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;





@RestController
@RequestMapping(value = "v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        studentService.saveStudent(studentDTO);
        //return "Student Saved";
        return new CommonResponse("Student save successfully",OPERATION_SUCCESS);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllStudents() {
        // return studentService.getAllStudents
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return new CommonResponse(OPERATION_SUCCESS,studentDTOList,SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/{student_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getStudentDetails(@PathVariable long student_id) {

        StudentDTO studentDetails = studentService.getStudentDetails(student_id);
        return new CommonResponse(OPERATION_SUCCESS,studentDetails,SUCCESS_MESSAGE);
    }
}
