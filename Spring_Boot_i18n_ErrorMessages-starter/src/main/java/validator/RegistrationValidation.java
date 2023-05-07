package validator;

import domain.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidation implements Validator {

	@Override
	public boolean supports(Class<?> klass) {
		return Registration.class.isAssignableFrom(klass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;

		if (registration.getPassword() == null || registration.getConfirmPassword() == null)
			return;

		if (!(registration.getPassword()).equals(registration.getConfirmPassword())) {
			errors.rejectValue("password", "matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}