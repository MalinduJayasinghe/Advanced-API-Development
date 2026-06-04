package lk.ijse.AAD_75.repository;

import lk.ijse.AAD_75.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "SELECT * FROM department WHERE department_name LIKE %?1%",nativeQuery = true)
    List<Department> filterDepartments(String departmentName);
}

