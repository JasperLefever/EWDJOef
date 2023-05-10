package exceptions;

public class FruitNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FruitNotFoundException(Integer id) {
	    super(String.format("Could not find fruit %s", id));
	  }
}