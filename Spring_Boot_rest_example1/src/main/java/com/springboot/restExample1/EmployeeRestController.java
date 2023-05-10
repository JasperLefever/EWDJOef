package com.springboot.restExample1;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Employee;
import service.EmployeeService;

@RestController
@RequestMapping(value = "/rest")
public class EmployeeRestController {
    
	@Autowired
	private EmployeeService employeeService;

    @GetMapping(value = "/emp/dummy") 
    public Employee getDummyEmployee() {
    	return employeeService.createDummyEmployee();  
    }
    
    @GetMapping(value = "/emp/{id}") 
    public Employee getEmployee(@PathVariable("id") int empId) {
    	return employeeService.getEmployee(empId);
    }

    @GetMapping(value = "/emps")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees(); 
    }
    
    @PostMapping(value = "/emp/create")
    public Employee createEmployee(@RequestBody Employee emp) { 
        emp.setCreatedDateTime(LocalDateTime.now());     
        return employeeService.createEmployee(emp); 
    }
    
    @DeleteMapping(value = "/emp/delete/{id}")
    public Employee deleteEmployee(@PathVariable("id") int empId) {
    	return employeeService.deleteEmployee(empId);
    }

}
