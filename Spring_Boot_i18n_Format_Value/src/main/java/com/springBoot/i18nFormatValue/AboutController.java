package com.springBoot.i18nFormatValue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {

    @Value("#{messageSource.getMessage('admin.email',null,'en')}")
    private String email;

    @GetMapping
    public String courtReservation(Model model) {
        model.addAttribute("email", email);
        return "about";
    }
}