package validator;

import domain.Numbers;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NumberValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Numbers.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Numbers numbers = (Numbers) target;

        if (numbers.getNumber1() != null && numbers.getNumber2() != null && numbers.getNumber1() >= numbers.getNumber2()) {
            errors.rejectValue("number1", "number1.error", "Number 1 must be smaller than number 2");
        }

    }
}
