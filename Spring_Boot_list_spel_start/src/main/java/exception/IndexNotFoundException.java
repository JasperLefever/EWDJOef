package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class IndexNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@Getter private final String message;
	

	
	public IndexNotFoundException()
	{
		message = "indexNotFoundMessage";
	}
	
}