package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.DepartmentDTO;
import lk.ijse.AAD_75.dto.request.UpdateDepartmentDTO;

import java.util.List;

public interface DepartmentService {

    void saveDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentDetails(long departmentId);
    void updateDepartment(DepartmentDTO departmentDTO);
    void updateLocation(UpdateDepartmentDTO updateDepartmentDTO);
    List<DepartmentDTO> filterDepartment(String departmentName);
}
