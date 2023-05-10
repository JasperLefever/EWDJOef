package perform;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Employee;
import reactor.core.publisher.Mono;

public class PerformRestExample {

	private final String SERVER_URI = "http://localhost:8080/rest";
	private WebClient webClient = WebClient.create();

	public PerformRestExample() throws Exception {
		System.out.println("\n------- GET ALL -------");
		getAllEmployee();
		
		System.out.println("------- GET DUMMY ------- ");
		getDummyEmployee();
		System.out.println("\n------- GET 9999 ------- ");
		getEmployee("9999");
		System.out.println("\n------- INSERT 100 ------- ");
		insertEmployee(100, "new employee");
		try
		{
			System.out.println("\n------- INSERT 100 second time ------- ");
			insertEmployee(100, "new employee");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n------- GET ALL -------");
		getAllEmployee();
		System.out.println("\n------- DELETE 9999 -------");
		deleteEmployee("9999");
		System.out.println("\n------- GET ALL -------");
		getAllEmployee();
		
		try
		{
			System.out.println("\n------- GET 9998 ------- ");
			getEmployee("9998");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			System.out.println("\n------- DELETE 9998 ------- ");
			deleteEmployee("9998");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void getAllEmployee() {
		webClient.get().uri(SERVER_URI + "/emps").retrieve()
        .bodyToFlux(Employee.class)
        .flatMap(emp -> {
            printEmpData(emp);
            return Mono.empty();
        })
        .blockLast();
	}

	private void getAnEmployee(String uri)
	{
		webClient.get()
	    .uri(uri)
	    .retrieve()
	    .bodyToMono(Employee.class)
	    .doOnSuccess(emp -> printEmpData(emp))
	    .block();
	}
	
	private void getEmployee(String number) {  
		getAnEmployee(SERVER_URI + "/emp/" + number);
	}

	private void getDummyEmployee() {
		getAnEmployee(SERVER_URI + "/emp/dummy");
	}
	
	private void insertEmployee(int id, String name) throws Exception {

	    Employee emp = new Employee(id,name);

	    ObjectMapper mapper = new ObjectMapper();
	    String empJson = mapper.writeValueAsString(emp);

	    webClient.post().uri(SERVER_URI + "/emp/create")
	        .contentType(MediaType.APPLICATION_JSON)
	        .body(BodyInserters.fromValue(empJson))
	        .retrieve().bodyToMono(Employee.class)
	        .block();
	}

	private void deleteEmployee(String number) {
		webClient.delete().uri(SERVER_URI + "/emp/delete/"+number).retrieve()
		.bodyToMono(Employee.class).block();
	}

	private void printEmpData(Employee emp) {
		System.out.printf("ID=%s, Name=%s, CreatedDateTime=%s%n", 
				emp.getId(), emp.getName(), emp.getCreatedDateTime());
	}

}
