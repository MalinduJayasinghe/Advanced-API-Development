package lk.ijse.AAD_75.service.impl;

import lk.ijse.AAD_75.dto.SchoolDTO;
import lk.ijse.AAD_75.dto.StudentDTO;
import lk.ijse.AAD_75.entity.School;
import lk.ijse.AAD_75.entity.Student;
import lk.ijse.AAD_75.repository.SchoolRepository;
import lk.ijse.AAD_75.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    public void saveSchool(SchoolDTO schoolDTO) {

        log.info("Execute method saveSchool");

        try {
            School school = new School();
            school.setSchool_id(schoolDTO.getSchool_id());
            school.setSchool_name(schoolDTO.getSchool_name());
            school.setSchool_location(schoolDTO.getSchool_location());

            schoolRepository.save(school);

            log.info("School saved successfully");
        }catch (Exception e){
            log.info("Error in method saveSchool" + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SchoolDTO> getAllSchools() {

        try {
            log.info("Execute method getAllSchools");
            List<SchoolDTO> responseList = new ArrayList<>();
            List <School> schoolList = schoolRepository.findAll();

            for (School school : schoolList) {

                SchoolDTO schoolDTO = new SchoolDTO();
                schoolDTO.setSchool_id(school.getSchool_id());
                schoolDTO.setSchool_name(school.getSchool_name());
                schoolDTO.setSchool_location(school.getSchool_location());
                responseList.add(schoolDTO);
            }

            log.info("School list retrieved successfully");
            return responseList;
        }catch (Exception e){
            log.info("Error in method getAllSchools" + e.getMessage());
            throw e;
        }
    }
}
