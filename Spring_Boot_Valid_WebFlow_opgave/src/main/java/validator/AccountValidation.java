package validator;

import domain.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class AccountValidation implements Validator {

    public boolean supports(Class<?> klass) {
        return Account.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;

        double percent = account.getPercent();

        if ((int) (percent * 100) % 2 != 0) {
            errors.rejectValue("percent", "percent.not.even");
        }

    }

}
