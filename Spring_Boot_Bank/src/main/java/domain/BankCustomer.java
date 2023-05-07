package domain;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankCustomer {

    @Pattern(regexp = "^[1-9]\\d{2}$", message = "Must be between 100 and 999")
	private String id;

	private String firstname, lastname;

    private double balance;

    public BankCustomer(String id){
        this.id = id;
    }

    public double getBalanceNoSign()
    {
        return Math.abs(balance);
    }

}