package com.springboot.spring_boot_i18n_format_starter;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping
	public String welcome(Model model) {
		
		Date today = new Date();
		LocalDate todayLocalDate = LocalDate.now();
		
		model.addAttribute("today", today);
		model.addAttribute("todayLocalDate", todayLocalDate);
		
		return "welcome";
	}

}