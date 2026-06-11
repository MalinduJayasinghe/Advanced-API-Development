package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.dto.StudentDTO;
import lk.ijse.AAD_75.entity.Employee;
import lk.ijse.AAD_75.entity.School;
import lk.ijse.AAD_75.entity.Student;
import lk.ijse.AAD_75.repository.SchoolRepository;
import lk.ijse.AAD_75.repository.StudentRepository;
import lk.ijse.AAD_75.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public void saveStudent(StudentDTO studentDTO) throws Exception {

        log.info("Execute method saveStudent");

        try {

            if(studentDTO.getStudent_fname() == null)
                throw new RuntimeException("Student first name is empty");

            Student student = new Student();
            student.setStudent_id(student.getStudent_id());
            student.setStudent_fname(student.getStudent_contact());
            student.setStudent_lastname(student.getStudent_lastname());
            student.setStudent_contact(student.getStudent_contact());

            Optional<School> optionalSchool = schoolRepository.findById(studentDTO.getSchool_id());

            if(optionalSchool.isEmpty()){
                throw new RuntimeException("School not found");
            }

            studentRepository.save(student);
            log.info("Student saved successfully");
        }catch (Exception e){
            log.info("Error in method saveStudent" + e.getMessage());
            throw e;
        }

    }

    @Override
    public List<StudentDTO>getAllStudents(){
        try {
            log.info("Execute method getAllStudents");
            List<StudentDTO> responseList = new ArrayList<>();
            List <Student> studentList = studentRepository.findAll();

            for (Student student : studentList) {

                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setStudent_id(student.getStudent_id());
                studentDTO.setStudent_fname(student.getStudent_fname());
                studentDTO.setStudent_lastname(student.getStudent_lastname());
                studentDTO.setStudent_contact(student.getStudent_contact());

                responseList.add(studentDTO);
            }

            log.info("Student list retrieved successfully");
            return responseList;
        }catch (Exception e){
            log.info("Error in method getAllStudents" + e.getMessage());
            throw e;
        }
    }

    @Override
    public StudentDTO getStudentDetails(long student_id) {

        log.info("Execute method getStudentDetails");

        try {
            Optional<Student> optionalStudent = studentRepository.findById(student_id);

            if (optionalStudent.isEmpty()) {
                throw new RuntimeException("Student not found");
            }

            Student student = optionalStudent.get();
            StudentDTO responseData = new StudentDTO();

            responseData.setStudent_id(student.getStudent_id());
            responseData.setStudent_fname(student.getStudent_fname());
            responseData.setStudent_lastname(student.getStudent_lastname());
            responseData.setStudent_contact(student.getStudent_contact());
            return responseData;

        }catch (Exception e){
            log.info("Error in method getStudentDetails" + e.getMessage());
            throw e;
        }
    }
}
