package lk.ijse.AAD_75.controller;

import lk.ijse.AAD_75.constant.CommonResponse;
import lk.ijse.AAD_75.dto.SchoolDTO;
import lk.ijse.AAD_75.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.AAD_75.constant.ResponseCode.OPERATION_SUCCESS;
import static lk.ijse.AAD_75.constant.ResponseMessage.SUCCESS_MESSAGE;

@RestController
@RequestMapping(value = "v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveSchool(@RequestBody SchoolDTO schoolDTO) {
        schoolService.saveSchool(schoolDTO);
        //return "School Saved";
        return new CommonResponse("School saved successfully",OPERATION_SUCCESS);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllSchools() {
        //return schoolService.getAllSchools();
        return new CommonResponse(OPERATION_SUCCESS,schoolService.getAllSchools(),SUCCESS_MESSAGE);
    }
}
