package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.dto.request.UpdateAddressDTO;
import lk.ijse.AAD_75.entity.Employee;
import lk.ijse.AAD_75.enumeration.EmployeeStatus;
import lk.ijse.AAD_75.repository.EmployeeRepository;
import lk.ijse.AAD_75.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void saveEmployee(EmployeeDTO employeeDTO) {

        log.info("Execute method saveEmployee");

        try {
            Employee employee = new Employee();
            employee.setFirstName(employee.getFirstName());
            employee.setLastName(employee.getLastName());
            employee.setAddress(employee.getAddress());
            employee.setJoinedDate(employee.getJoinedDate());

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

    @Override
    public EmployeeDTO getEmployeeDetails(long employeeId) {
        log.info("Execute method getEmployeeDetails");

        try {

            // Using the findByID method,
            // we can pass a primary key as a parameter and retrieve the relevant record
            // This gives an Optional type output, so we must use an if statement with the isEmpty
            // method to check if the relevant field is empty and display a message if it is
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

            if (optionalEmployee.isEmpty()) {
                throw new RuntimeException("Employee not found");
            }

            Employee employee = optionalEmployee.get();
            EmployeeDTO responseData = new EmployeeDTO();

            responseData.setEmployeeId(employee.getEmployeeId());
            responseData.setFirstName(employee.getFirstName());
            responseData.setLastName(employee.getLastName());
            responseData.setAddress(employee.getAddress());
            responseData.setJoinedDate(employee.getJoinedDate());

            return responseData;

        }catch (Exception e){
            log.error("Error in method getEmployeeDetails" + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {

        log.info("Execute method updateEmployee");

        try {

            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDTO.getEmployeeId());

            if (optionalEmployee.isEmpty()) {
                throw new RuntimeException("Employee not found");
            }

            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setAddress(employeeDTO.getAddress());
            employee.setJoinedDate(employeeDTO.getJoinedDate());
            employeeRepository.save(employee);

        }catch (Exception e){
            log.info("Error in method updateEmployee" + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateAddress(UpdateAddressDTO updateAddressDTO) {

        log.info("Execute method updateAddress");
        try {

            Optional<Employee> optionalEmployee = employeeRepository.findById(updateAddressDTO.getEmployeeId());

            if (optionalEmployee.isEmpty()) {
                throw new RuntimeException("Employee not found");
            }

            Employee employee = optionalEmployee.get();
            employee.setAddress(updateAddressDTO.getAddress());
            employeeRepository.save(employee);

        }catch (Exception e){
            log.info("Error in method updateAddress" + e.getMessage());
        }
    }

    @Override
    public void changeEmployeeStatus(long employeeId) {

        log.info("Execute method changeEmployeeStatus");

        try {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
            if (optionalEmployee.isEmpty()) {
                throw new RuntimeException("Employee not found");
            }

            Employee employee = optionalEmployee.get();
            employee.setEmployeeStatus(EmployeeStatus.INACTIVE);
            employeeRepository.save(employee);

        }catch (Exception e){
            log.info("Error in method changeEmployeeStatus" + e.getMessage());
            throw e;
        }
    }
}
