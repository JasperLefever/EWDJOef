package validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenConstraintValidator implements ConstraintValidator<Even,Integer>
{
    @Override
    public void initialize(Even constraintAnnotation) {}

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 2 == 0;
    }
}