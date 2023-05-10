package service;

import java.util.List;

import domain.Employee;

public interface EmployeeService {

	public Employee getEmployee(int empId);
	
	public List<Employee> getAllEmployees();
	
	public Employee createDummyEmployee();
	
	public Employee createEmployee(Employee emp);
	
	public Employee deleteEmployee(int empId);

}
