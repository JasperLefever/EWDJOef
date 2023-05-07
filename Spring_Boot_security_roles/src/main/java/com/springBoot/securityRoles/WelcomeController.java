package com.springBoot.securityRoles;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String listStudents(Model model, Authentication authentication) {
        
    	List<String> listRoles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
    	    		
    	model.addAttribute("username", authentication.getName());
        model.addAttribute("userListRoles", listRoles);
        
        return "welcome";
    }

}