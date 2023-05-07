package exceptions;

public class PerformanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PerformanceException() {
    }

    public PerformanceException(String message) {
        super(message);
    }
}