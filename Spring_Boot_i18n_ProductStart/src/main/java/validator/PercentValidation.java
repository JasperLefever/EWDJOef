package validator;

import domain.Price;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PercentValidation implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Price.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Price price = (Price) target;
        Integer percentIncrease = price.getPercentIncrease();
        Integer percentDecrease = price.getPercentDecrease();

        if(percentIncrease == null || percentDecrease == null) {
           return;
        }
        if(percentDecrease > percentIncrease){
            errors.rejectValue("percentIncrease", "percentValidation.percent");
        }

    }

}