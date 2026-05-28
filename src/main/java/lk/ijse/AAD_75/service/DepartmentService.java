package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    void saveDepartment();
    List<DepartmentDTO> getAllDepartments();
}
