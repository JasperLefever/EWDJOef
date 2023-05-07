package validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EvenConstraintValidator.class)
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Even {

    String message() default "must have even number";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}