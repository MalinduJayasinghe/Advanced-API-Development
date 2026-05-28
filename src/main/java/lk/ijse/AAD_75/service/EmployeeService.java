package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void saveEmployee();
    List<EmployeeDTO> getAllEmployees();
}
