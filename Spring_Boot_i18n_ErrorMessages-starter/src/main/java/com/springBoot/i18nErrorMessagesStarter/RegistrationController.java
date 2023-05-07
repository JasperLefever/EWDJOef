package com.springBoot.i18nErrorMessagesStarter;

import java.util.Locale;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Registration;
import utility.Message;
import validator.RegistrationValidation;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationValidation registrationValidation;
    
    @Autowired
    private MessageSource messageSource;

    // Display the form on the get request
    @GetMapping
    public String showRegistration(Model model) {
        Registration registration = new Registration();
        model.addAttribute("registration", registration);
        return "registrationForm";
    }

    // Process the form.
    @PostMapping
    public String processRegistration(@Valid Registration registration,
            BindingResult result, Model model, Locale locale) {

        registrationValidation.validate(registration, result);

        if (result.hasErrors()) { 
        	
            model.addAttribute("message",
                    new Message("error",
                            messageSource.getMessage("contact_save_fail",
                                    new Object[]{}, locale)));
          
            return "registrationForm";
        }

        registration.setConfirmPassword(null);
        registration.setPassword(null);

        return "registrationSuccess";
    }
}
