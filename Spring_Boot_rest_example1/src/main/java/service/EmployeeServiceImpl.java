package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Employee;
import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService {

	private Map<Integer, Employee> empData = new HashMap<>();

	public Employee getEmployee(int empId){
		Employee employee = empData.get(empId);
		if (employee == null)
			throw new EmployeeNotFoundException(empId);
		return employee;
	}

	public List<Employee> getAllEmployees() {
		return empData.values().stream().collect(Collectors.toList());
	}

	public Employee createDummyEmployee() {
		Employee emp = new Employee(9999, "Dummy");
		empData.put(9999, emp);
		return emp;
	}

	public Employee createEmployee(Employee emp) {
		if (empData.containsKey(emp.getId()))
			throw new DuplicateEmployeeException(emp.getId());
		empData.put(emp.getId(), emp);
		return emp;
	}

	public Employee deleteEmployee(int empId) {
		Employee employee = empData.get(empId);
		if (employee == null)
			throw new EmployeeNotFoundException(empId);
		empData.remove(empId);
		return employee;
	}
}
