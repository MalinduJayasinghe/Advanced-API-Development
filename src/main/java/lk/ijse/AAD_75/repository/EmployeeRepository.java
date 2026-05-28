package lk.ijse.AAD_75.repository;

import lk.ijse.AAD_75.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The JPA repo has some special in-built methods (like findById) to execute those methods
// it needs data to be input into it which is why we add the table name and data type in a Generic tag

// @Repository tag is used to tell the system that the program below is a repository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
