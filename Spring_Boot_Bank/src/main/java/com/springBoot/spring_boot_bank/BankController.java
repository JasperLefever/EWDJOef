package com.springBoot.spring_boot_bank;

import domain.BankCustomer;
import domain.BankCustomerLookup;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankCustomerLookup bankCustomerLookup;

    @GetMapping
    public String showHomePage(Model model){
        model.addAttribute("bankCustomer", new BankCustomer());
        return "form";
    }


    @PostMapping
    public String onSubmit(@Valid BankCustomer bankCustomer, BindingResult result, Model model){
        var currentCustomer = bankCustomerLookup.getCustomer(bankCustomer.getId());

        if(result.hasErrors()){
            return "form";
        }

        if (currentCustomer == null) {
            return "unknownCustomer";
        }

        model.addAttribute("customer", currentCustomer);

        if (currentCustomer.getBalance() < 0) {
            return "negativeBalance";
        }

        return "balance";
    }

}
