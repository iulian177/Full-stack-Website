package ro.springTutorial.myspringapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
