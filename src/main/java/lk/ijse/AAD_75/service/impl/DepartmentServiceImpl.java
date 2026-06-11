package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.DepartmentDTO;
import lk.ijse.AAD_75.dto.request.UpdateDepartmentDTO;
import lk.ijse.AAD_75.entity.Department;
import lk.ijse.AAD_75.repository.DepartmentRepository;
import lk.ijse.AAD_75.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment(DepartmentDTO departmentDTO) {

        log.info("Execute method saveDepartment");

        try {
            Department department = new Department();
            department.setDepartment_name(department.getDepartment_name());
            department.setDepartment_location(department.getDepartment_location());

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

    @Override
    public DepartmentDTO getDepartmentDetails(long departmentId) {

        log.info("Execute method getDepartmentDetails");

        try {
            Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);

            if (optionalDepartment.isEmpty()) {
                throw new RuntimeException("Department not found");
            }

            Department department = optionalDepartment.get();
            DepartmentDTO responseData = new DepartmentDTO();

            responseData.setDepartment_id(department.getDepartment_id());
            responseData.setDepartment_name(department.getDepartment_name());
            responseData.setDepartment_location(department.getDepartment_location());
            return responseData;

        }catch (Exception e){
            log.info("Error in method getDepartmentDetails" + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) {

        log.info("Execute method updateDepartment");

        try {

            Optional<Department> optionalDepartment = departmentRepository.findById(departmentDTO.getDepartment_id());

            if (optionalDepartment.isEmpty()) {
                throw new RuntimeException("Department not found");
            }

            Department department = optionalDepartment.get();
            department.setDepartment_location(departmentDTO.getDepartment_location());
            department.setDepartment_name(departmentDTO.getDepartment_name());
            departmentRepository.save(department);

        }catch (Exception e){
            log.info("Error in method updateDepartment" + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateLocation(UpdateDepartmentDTO updateDepartmentDTO) {

        log.info("Execute method updateLocation");

        try {

            Optional<Department> optionalDepartment = departmentRepository.findById(updateDepartmentDTO.getDepartment_id());

            if (optionalDepartment.isEmpty()) {
                throw new RuntimeException("Department not found");
            }

            Department department = optionalDepartment.get();
            department.setDepartment_location(updateDepartmentDTO.getDepartment_location());
            departmentRepository.save(department);

        }catch (Exception e){
            log.info("Error in method updateLocation" + e.getMessage());
        }
    }

    @Override
    public List<DepartmentDTO> filterDepartment(String departmentName) {

        log.info("Execute method filterDepartment");
        try {

            List<DepartmentDTO> responseList = new ArrayList<>();
            List<Department> departmentList = departmentRepository.filterDepartments(departmentName);

           for(Department department : departmentList){

               DepartmentDTO departmentDTO = new DepartmentDTO(
                       department.getDepartment_id(),
                       department.getDepartment_name(),
                       department.getDepartment_location()
               );

               responseList.add(departmentDTO);
           }

           return responseList;

        }catch (Exception e){
            log.info("Error in method filterDepartment" + e.getMessage());
            throw e;
        }
    }
}
