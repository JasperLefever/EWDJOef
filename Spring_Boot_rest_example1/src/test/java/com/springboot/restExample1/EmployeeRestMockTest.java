package com.springboot.restExample1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Employee;
import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;
import service.EmployeeService;
import static utils.InitFormatter.*;

@SpringBootTest
class EmployeeRestMockTest {

	@Mock
	private EmployeeService mock;
	
	private EmployeeRestController controller;
	private MockMvc mockMvc;

	private final int ID = 1234;
	private final String NAME = "Test";
	private String expectedFormattedDateTime;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
		controller = new EmployeeRestController();
		mockMvc = standaloneSetup(controller).build();
		ReflectionTestUtils.setField(controller, "employeeService", mock);
	}

	private Employee anEmployee(int id, String name) {
		Employee emp = new Employee(id, name);
		expectedFormattedDateTime = emp.getCreatedDateTime().format(FORMATTER);
		return emp;
	}

	private void performRest(String uri) throws Exception {
		mockMvc.perform(get(uri))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.employee_id").value(ID))
		.andExpect(jsonPath("$.name").value(NAME))
		.andExpect(jsonPath("$.createdDateTime").value(expectedFormattedDateTime));
	}
	
	@Test
	public void testDummyEmployee_isOk() throws Exception {
		Mockito.when(mock.createDummyEmployee()).thenReturn(anEmployee(ID, NAME));
		performRest("/rest/emp/dummy");
		Mockito.verify(mock).createDummyEmployee();
	}
	
	@Test
	public void testGetEmployee_isOk() throws Exception {
		Mockito.when(mock.getEmployee(ID)).thenReturn(anEmployee(ID, NAME));
		performRest("/rest/emp/" + ID);
		Mockito.verify(mock).getEmployee(ID);
	}

	@Test
	public void testGetEmployee_notFound() throws Exception {
		Mockito.when(mock.getEmployee(ID)).thenThrow(new EmployeeNotFoundException(ID));
		Exception exception = assertThrows(Exception.class, () -> {
			mockMvc.perform(get("/rest/emp/" + ID)).andReturn();
	    });
		
		assertTrue(exception.getCause() instanceof EmployeeNotFoundException);
		
		Mockito.verify(mock).getEmployee(ID);
	}

	@Test
	public void testGetAllEmployees_emptyList() throws Exception {
		Mockito.when(mock.getAllEmployees()).thenReturn(new ArrayList<>());
		
		mockMvc.perform(get("/rest/emps"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$").isEmpty());
		
		Mockito.verify(mock).getAllEmployees();
	}

	@Test
	public void testGetAllEmployees_noEmptyList() throws Exception {
		Employee employee1 = anEmployee(ID, NAME);
		String expectedFormattedDateTime1 = expectedFormattedDateTime;
		Employee employee2 = anEmployee(5678, "Test2");
		String expectedFormattedDateTime2 = expectedFormattedDateTime;
		List<Employee> listEmployee = List.of(employee1, employee2);
		Mockito.when(mock.getAllEmployees()).thenReturn(listEmployee);

		mockMvc.perform(get("/rest/emps")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$").isNotEmpty())
				.andExpect(jsonPath("$[0].employee_id").value(ID))
				.andExpect(jsonPath("$[0].name").value(NAME))
				.andExpect(jsonPath("$[0].createdDateTime").value(expectedFormattedDateTime1))
				.andExpect(jsonPath("$[1].employee_id").value(5678)).andExpect(jsonPath("$[1].name").value("Test2"))
				.andExpect(jsonPath("$[1].createdDateTime").value(expectedFormattedDateTime2));
		
		Mockito.verify(mock).getAllEmployees();
	}

	@Test
	public void testCreateEmployee() throws Exception {
	    Employee emp = new Employee(ID, NAME);
	    String empJson = new ObjectMapper().writeValueAsString(emp);

	    Mockito.when(mock.createEmployee(Mockito.any(Employee.class))).thenReturn(emp);
	    
	    mockMvc.perform(post("/rest/emp/create")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(empJson))
	            .andExpect(status().isOk())
	    
	            .andExpect(jsonPath("$.employee_id").value(ID))
	            .andExpect(jsonPath("$.name").value(NAME))
	            .andExpect(jsonPath("$.createdDateTime").isNotEmpty());
	    
	    Mockito.verify(mock).createEmployee(Mockito.any(Employee.class));
	}
	
	@Test
	public void testCreateEmployee_duplicateKey() throws Exception {
		String empJson = new ObjectMapper().writeValueAsString(new Employee(ID, NAME));
		
        Mockito.when(mock.createEmployee(Mockito.any(Employee.class))).thenThrow(new DuplicateEmployeeException(ID));
        
        Exception exception = assertThrows(Exception.class, () -> {
        mockMvc.perform(post("/rest/emp/create")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(empJson))
        		.andReturn();
        });
		assertTrue(exception.getCause() instanceof DuplicateEmployeeException);
		
		Mockito.verify(mock).createEmployee(Mockito.any(Employee.class));
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
		Mockito.when(mock.deleteEmployee(ID)).thenReturn(anEmployee(ID, NAME));
		
		mockMvc.perform(delete("/rest/emp/delete/" + ID))
		.andExpect(status().isOk())
        .andExpect(jsonPath("$.employee_id").value(ID))
        .andExpect(jsonPath("$.name").value(NAME))
        .andExpect(jsonPath("$.createdDateTime").value(expectedFormattedDateTime));
		
		Mockito.verify(mock).deleteEmployee(ID);
	}
	
	
	@Test
	public void testDeleteEmployee_notFound() throws Exception {
	
        Mockito.when(mock.deleteEmployee(ID)).thenThrow(new EmployeeNotFoundException(ID));
        
        Exception exception = assertThrows(Exception.class, () -> {
        mockMvc.perform(delete("/rest/emp/delete/" + ID))
        		.andReturn();
        });
        
        assertTrue(exception.getCause() instanceof EmployeeNotFoundException);
        Mockito.verify(mock).deleteEmployee(ID);
	}
	
}
