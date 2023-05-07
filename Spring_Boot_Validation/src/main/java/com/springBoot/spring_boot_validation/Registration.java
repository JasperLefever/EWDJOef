package com.springBoot.spring_boot_validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
//import validator.ValidEmail;

@Getter @Setter
public class Registration {

	@Pattern(regexp = "^[a-zA-Z]+", message = "username must be alphanumeric with no spaces")
    private String userName;

	@NotBlank
	@Size(min = 4, max = 20)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    @Email
    //@ValidEmail
    private String email;

}