package ro.springTutorial.myspringapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Containerul in care sunt injectate dependintele(component, service, repository)
//Controlerul face legatura cu lumea de afara
//Repository comunica direct cu baza de date
//Service face logica de business(ce face aplicatia)
//prin dependency injection nu trebuie sa instantiem clasele in container;
// doar le "instantiem" ca variabile(cu Autowired) sau prin constructor
@RestController
@RequestMapping(path = "/api/employees")
public class EmployeesController {

    //private final EmployeeRepository employeeRepository;
    // o inlocuim pt a conecta controlerul de Repository prin service
    //asa putem de exemplu sa stilizam un mesaj de eroare de la baza de date
    private final EmployeeService employeeService;
    @Autowired  //nu se recomanda
    private MyClass myClass;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
        //return employeeService.findAll();
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/Hello")
    public String sayHello() {
        return myClass.sayHello();
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


//        return List.of(new Employee("T", "Iulian",
//                21, "gg@gmail.com", "Cluj-Napoca", "student" ),
//                new Employee("G", "Ion",
//                        26, "g.Ion24@gmail.com", "Cluj-Napoca", "programmer" ));

}
