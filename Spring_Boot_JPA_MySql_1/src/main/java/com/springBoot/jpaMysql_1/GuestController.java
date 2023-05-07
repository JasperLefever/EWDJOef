package com.springBoot.jpaMysql_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import repository.GuestRepository;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestRepository repository;

	@GetMapping
	public String listGuest(Model model) {

		model.addAttribute("guestList", repository.findAll());
		model.addAttribute("guestName", repository.findByName("Blondeel"));
		model.addAttribute("guestFirstname", repository.findByFirstname("Sandra"));

        model.addAttribute("guestList2", repository.findByNameStartingWith("blon"));
		model.addAttribute("guestList3", repository.findByNameStartingWith2("k"));
		
		return "guest";
	}
}
