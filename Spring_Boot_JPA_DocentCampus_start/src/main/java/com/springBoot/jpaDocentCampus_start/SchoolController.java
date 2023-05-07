package com.springBoot.jpaDocentCampus_start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import repository.CampusRepository;
import repository.DocentRepository;
import repository.WerkruimteRepository;
import service.SchoolService;

@Controller
public class SchoolController {

   @Autowired
   private SchoolService schoolService;

   @Autowired
   private DocentRepository docentRepository;

   @Autowired
   private CampusRepository campusRepository;

   @Autowired
   private WerkruimteRepository werkruimteRepository;

   
   @GetMapping(value = "/school")
   public String listSchool(Model model) {
	   
	   schoolService.changeWerkruimte("SCH555", "Gent", "Aalst");
       model.addAttribute("docentList", docentRepository.findAll());
       
       model.addAttribute("campusList", campusRepository.findAll());
       
       model.addAttribute("werkruimteList", werkruimteRepository.findAll());
       
       return "school";
   }
    
 }