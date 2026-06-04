package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.DepartmentDTO;
import lk.ijse.AAD_75.dto.request.UpdateDepartmentDTO;
import lk.ijse.AAD_75.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;

@RestController
@RequestMapping(value = "v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.saveDepartment();
        return "Department Saved";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDTO> getAllDepartments(@RequestBody DepartmentDTO departmentDTO) {
        List<DepartmentDTO> allDepartments = departmentService.getAllDepartments();
        return allDepartments;
    }

    @GetMapping(value = "/{departmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getDepartmentDetails(@PathVariable long departmentId) {

        DepartmentDTO departmentDetails = departmentService.getDepartmentDetails(departmentId);
        return new CommonResponse(OPERATION_SUCCESS, departmentDetails, SUCCESS_MESSAGE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateDepartment(@RequestBody DepartmentDTO departmentDTO) {

        departmentService.updateDepartment(departmentDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateLocation(@RequestBody UpdateDepartmentDTO updateDepartmentDTO) {

        departmentService.updateLocation(updateDepartmentDTO);
        return new CommonResponse(SUCCESS_MESSAGE, OPERATION_SUCCESS);
    }

    @GetMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterDepartments(@RequestParam(value = "departmentName", required = false) String departmentName) {

        List<DepartmentDTO> departmentDTOS = departmentService.filterDepartment(departmentName);
        return new CommonResponse(OPERATION_SUCCESS, departmentDTOS, SUCCESS_MESSAGE);
    }
}
