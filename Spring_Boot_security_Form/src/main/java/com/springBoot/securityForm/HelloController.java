package com.springBoot.securityForm;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value = "/hello")
	public String printWelcome(Model model, Principal principal) {

		model.addAttribute("username", principal.getName());
		return "hello";
	}

}