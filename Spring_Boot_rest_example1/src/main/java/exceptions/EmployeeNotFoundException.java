package exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Integer id) {
	    super(String.format("Could not find employee %s", id));
	  }
}