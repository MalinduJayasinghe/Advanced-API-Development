package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.dto.DepartmentDTO;
import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDepartment() {
        departmentService.saveDepartment();
        return "Department Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentDTO> allDepartments = departmentService.getAllDepartments();
        return allDepartments;
    }
}
