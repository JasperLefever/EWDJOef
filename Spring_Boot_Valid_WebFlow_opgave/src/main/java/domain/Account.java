package domain;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Account {

	//moet ingevuld zijn
	//minstens 10000
    @NotNull
    @Min(10000)
    @NumberFormat(pattern = "#,##0.00")
    @Setter
    private BigDecimal balance = new BigDecimal("20003000.2599");

    //Tussen 0 en 60%
                  //"must be greater than or equal to 0%"
                  //message = "must be less than or equal to 60%"
    @DecimalMin(value = "0.0", message = "must be greater than or equal to 0%")
    @DecimalMax(value = "0.6", message = "must be less than or equal to 60%")
    @NumberFormat(style = Style.PERCENT)
    @Setter
    private double percent = 0.25;

    private BigDecimal balance2;
    private double percent2;

    //moet ingevuld zijn
    //moet geldige email zijn
    @NotBlank
    @Email
    @Setter
    private String email;

    public void simpleExample() {
        balance2 = new BigDecimal("20003000.2599");
        percent2 = percent;
    }
    
}
