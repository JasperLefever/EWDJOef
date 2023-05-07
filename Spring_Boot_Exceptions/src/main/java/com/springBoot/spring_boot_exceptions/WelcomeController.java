package com.springBoot.spring_boot_exceptions;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Example;
import exception.CustomGenericException;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome(Model model) {
        Date today = new Date();
        //new Example();
        
        model.addAttribute("today", today);
        return "welcome";
    }

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {
        ModelAndView model
                = new ModelAndView("error/generic_error");
        model.addObject("errCode", ex.getErrCode());
        model.addObject("errMsg", ex.getErrMsg());
        return model;
    }

}
