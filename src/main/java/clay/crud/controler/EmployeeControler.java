package clay.crud.controler;


import clay.crud.entity.Employee;
import clay.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeControler {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/all")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping("/all/{id}")
    public Employee saveEmployee( @PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee( @PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee( @RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }



}
