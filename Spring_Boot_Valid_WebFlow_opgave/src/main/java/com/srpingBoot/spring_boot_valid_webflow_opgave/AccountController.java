package com.srpingBoot.spring_boot_valid_webflow_opgave;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Account;
import validator.AccountValidation;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountValidation accountValidation;
       
    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("account", new Account());
        return "accountForm";
    }
        
    @PostMapping
    public String onSubmit(@Valid Account account, BindingResult result, Model model) {
        accountValidation.validate(account, result);
        if (result.hasErrors()) {
            return "accountForm";
        }

        account.simpleExample();
        return "exampleView";
    }
  
}









