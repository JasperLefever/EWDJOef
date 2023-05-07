package exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ReservationNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@Getter private final String courtName;
	@Getter private final Date date;
	@Getter private final int hour;

}