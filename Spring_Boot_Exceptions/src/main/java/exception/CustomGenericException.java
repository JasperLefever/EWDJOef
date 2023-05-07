package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CustomGenericException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
	@Getter @Setter private String errCode;
	@Getter @Setter private String errMsg;
 
}