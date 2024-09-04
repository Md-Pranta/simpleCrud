package clay.crud.service;


import clay.crud.dao.EmployeeDao;
import clay.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee saveEmployee(Employee employee){
        return employeeDao.save(employee);
    }

    public List<Employee> getEmployee(){
        List<Employee> employees = new ArrayList<>();
        employeeDao.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployeeById(Integer id){
        return employeeDao.findById(id).orElseThrow();
    }

    public void deleteEmployeeById(Integer id){
        employeeDao.deleteById(id);
    }

    public Employee updateEmployee(Employee employee){
        employeeDao.findById(employee.getEmployeeId()).orElseThrow();
        return employeeDao.save(employee);
    }
}
