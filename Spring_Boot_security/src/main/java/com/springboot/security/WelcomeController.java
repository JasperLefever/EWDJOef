package com.springBoot.security;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping(value = "/welcome")
    public String printWelcome(Model model, Principal principal) {

        model.addAttribute("username", principal.getName());
        model.addAttribute("message", "Spring Security Custom Form example");
        return "hello";
    }

}