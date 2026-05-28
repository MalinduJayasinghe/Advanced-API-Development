package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.entity.Employee;
import lk.ijse.AAD_75.repository.EmployeeRepository;
import lk.ijse.AAD_75.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Normally you would have to create this constructor yourself for every repo you added to the
    //  program, but this can be handled automatically with the @RequiredArgsConstructor

    // It creates all the required Constructors for all the repos as necessary
    /*
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/

    @Override
    public void saveEmployee() {

        log.info("Execute method saveEmployee");

        try {
            Employee employee = new Employee();
            employee.setFirstName("Yasiru");
            employee.setLastName("Amarathunga");
            employee.setAddress("Panadura");
            employee.setJoinedDate(LocalDateTime.now());

            employeeRepository.save(employee);
            log.info("Employee saved successfully");
        }catch (Exception e){
            log.info("Error in method saveEmployee" + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees(){

        try {
            log.info("Execute method getAllEmployees");
            List<EmployeeDTO> responseList = new ArrayList<>();
            List <Employee> employeeList = employeeRepository.findAll();

            for (Employee employee : employeeList) {

                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setEmployeeId(employee.getEmployeeId());
                employeeDTO.setFirstName(employee.getFirstName());
                employeeDTO.setLastName(employee.getLastName());
                employeeDTO.setAddress(employee.getAddress());
                employeeDTO.setJoinedDate(employee.getJoinedDate());

                responseList.add(employeeDTO);
            }

            log.info("Employee list retrieved successfully");
            return responseList;
        }catch (Exception e){
            log.info("Error in method getAllEmployees" + e.getMessage());
            throw e;
        }
    }
}
