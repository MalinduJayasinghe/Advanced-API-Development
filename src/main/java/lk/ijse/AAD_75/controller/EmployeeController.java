package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// @RestController is made up of the @Controller and @ResponseBody annotations

@RestController
@RequestMapping(value = "v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee();
        return "Employee Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAllEmployees(@RequestBody EmployeeDTO employeeDTO) {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
}
