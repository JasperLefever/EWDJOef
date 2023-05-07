package com.springBoot.spring_boot_oef_validation;

import domain.Numbers;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.NumberValidation;

@Controller
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberValidation numberValidation;

    @GetMapping
    public String showRegistration(Model model) {
        Numbers theNumber = new Numbers();
        model.addAttribute("numbers", theNumber);
        return "numberForm";
    }

    @PostMapping
    public String processNumbers(@Valid Numbers numbers, BindingResult result, Model model) {

        numberValidation.validate(numbers, result);
        if (result.hasErrors()) {
            return "numberForm";
        }


        return "numberSuccess";
    }
}
