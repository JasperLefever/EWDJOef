package domain;

import exception.CustomGenericException;
import exception.ReservationNotAvailableException;
import java.util.Date;

public class Example {
  
    public Example()
    {
        throw new ReservationNotAvailableException("iTalent", new Date(), 12);
        //throw new NumberFormatException();
        //throw new CustomGenericException("E888", "This is custom message");
        //throw new IllegalArgumentException();
    }
}
