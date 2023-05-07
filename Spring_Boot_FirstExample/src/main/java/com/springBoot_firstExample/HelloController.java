package com.springBoot_firstExample;

import domain.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String showFormPage(Model model) {
        model.addAttribute("name", new Name());
        log.info("get hello");
        return "nameForm";
    }

    @PostMapping("/hello")
    public String onSubmit(Name name, Model model) {
        model.addAttribute("helloMessage", helloService.sayHello(name.getValue()));
        log.info("post hello with name: " + name.getValue() + "");

        return "helloView";
    }




}
