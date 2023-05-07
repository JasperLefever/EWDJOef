package com.springboot.securityListStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import service.StudentService;
import service.StudentServiceImpl;

@SpringBootApplication
public class SpringBootSecurityListStartApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityListStartApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/students/list");
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl();
    }
}
