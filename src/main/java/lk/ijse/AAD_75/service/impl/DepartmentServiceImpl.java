package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.DepartmentDTO;
import lk.ijse.AAD_75.entity.Department;
import lk.ijse.AAD_75.repository.DepartmentRepository;
import lk.ijse.AAD_75.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment() {

        log.info("Execute method saveDepartment");

        try {
            Department department = new Department();
            department.setDepartment_name("HR");
            department.setDepartment_location("Building A1");

            departmentRepository.save(department);
            log.info("Department saved successfully");
        }catch (Exception e){
            log.info("Error in method saveDepartment" + e.getMessage());
        }
    }

    @Override
    public List<DepartmentDTO> getAllDepartments (){

        try {
            log.info("Execute method getAllDepartments");
            List<DepartmentDTO> responseList = new ArrayList<>();
            List<Department> departmentList = departmentRepository.findAll();

            for (Department department : departmentList){

                DepartmentDTO departmentDTO = new DepartmentDTO();
                departmentDTO.setDepartment_id(department.getDepartment_id());
                departmentDTO.setDepartment_name(department.getDepartment_name());
                departmentDTO.setDepartment_location(department.getDepartment_location());

                responseList.add(departmentDTO);
            }

            log.info("Department list retrieved successfully");
            return responseList;
        }catch (Exception e){
            log.info("Error in method getAllDepartments" + e.getMessage());
            throw e;
        }
    }
}
