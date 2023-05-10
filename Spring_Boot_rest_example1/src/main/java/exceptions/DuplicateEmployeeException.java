package exceptions;

public class DuplicateEmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateEmployeeException(Integer id) {
	    super(String.format("Duplicate employee %s", id));
	}
}

