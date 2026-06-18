package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.EmployeeDTO;
import lk.ijse.AAD_75.dto.request.UpdateAddressDTO;
import lk.ijse.AAD_75.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;


// @RestController is made up of the @Controller and @ResponseBody annotations

@RestController
@RequestMapping(value = "v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "Employee Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAllEmployees(@RequestBody EmployeeDTO employeeDTO) {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees(employeeDTO);
        return allEmployees;
    }


    // All mapping values must be unique, so we must add a unique path to each method
    @GetMapping(value = "/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getEmployeeDetails(@PathVariable long employeeId) {

        EmployeeDTO employeeDetails = employeeService.getEmployeeDetails(employeeId);
        return new CommonResponse(OPERATION_SUCCESS, employeeDetails, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

        employeeService.updateEmployee(employeeDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateAddress(@RequestBody UpdateAddressDTO updateAddressDTO) {

        employeeService.updateAddress(updateAddressDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @DeleteMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse changeEmployeeStatus(@PathVariable long employeeId) {

        employeeService.changeEmployeeStatus(employeeId);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }
}
