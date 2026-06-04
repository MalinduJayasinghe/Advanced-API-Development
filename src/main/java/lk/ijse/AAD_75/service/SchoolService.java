package lk.ijse.AAD_75.service;

import lk.ijse.AAD_75.dto.SchoolDTO;

import java.util.List;

public interface SchoolService {

    void saveSchool(SchoolDTO schoolDTO);
    List<SchoolDTO> getAllSchools();
}
