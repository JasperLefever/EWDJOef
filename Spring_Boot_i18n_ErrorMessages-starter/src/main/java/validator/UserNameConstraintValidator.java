package validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameConstraintValidator implements ConstraintValidator<ValidUserName,String>
{
    @Override
    public void initialize(ValidUserName constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        
        return (username.matches("^[a-zA-Z]+"));
    }
}