package ro.springTutorial.myspringapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
//        Optional<Employee> employeeOptional = employeeRepository.getEmployeeByEmailAddress(employee.getEmailAdress());
//        if(employeeOptional.isPresent()) {
//            throw new IllegalStateException(String.format("Email adress %s" +
//                    " already exists", employee.getEmailAdress()));
//        }

        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with format %s doesn't exist", id)));
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setAdress(employee.getAdress());
        employeeToUpdate.setAge(employee.getAge());
        employeeToUpdate.setEmailAdress(employee.getEmailAdress());
        employeeToUpdate.setRole(employee.getRole());

        employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployee(Long id) {
        Boolean employeeExists = employeeRepository.existsById(id);
        if (!employeeExists) {
            throw new IllegalStateException(String.format("Employee with id %s does not exists", id));
        }
        employeeRepository.deleteById(id);
    }


}
