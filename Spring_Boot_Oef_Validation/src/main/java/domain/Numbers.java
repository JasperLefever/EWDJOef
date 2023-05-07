package domain;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;
import validator.Even;

@Getter @Setter
public class Numbers {
    
    /* amount
    	maximum is 5000.50 (grens inbegrepen)
	wordt steeds met twee cijfers na de komma afgebeeld
	initiële waarde = 2000.856
     */
    @NumberFormat(pattern = "#.00")
    @DecimalMax(value = "5000.50", message = "Maximum is 5000.50")
    private Double amount = 2000.856;
   
    /* number1
                moet ingevuld zijn
                moet liggen tussen 1 en 11000 (grenzen inbegrepen)
    	initiële waarde = 2000 (wordt afgebeeld als 2.000)
     */
    @Even
    @NotNull(message = "Number is required")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(value = 1, message = "Minimum is 1")
    @Max(value = 11000, message = "Maximum is 11000")
    private Integer number1 = 2000;
  
    /*     
    number2 
        moet ingevuld zijn
        initiële waarde = 1234566
     */
    @Even
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull(message = "Number is required")
    private Integer number2 = 1234566;

}
