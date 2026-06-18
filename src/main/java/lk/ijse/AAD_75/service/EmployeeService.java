package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.dto.request.UpdateAddressDTO;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeDetails(long employeeId);
    void updateEmployee(EmployeeDTO employeeDTO);
    void updateAddress(UpdateAddressDTO updateAddressDTO);
    void changeEmployeeStatus(long employeeId);
}