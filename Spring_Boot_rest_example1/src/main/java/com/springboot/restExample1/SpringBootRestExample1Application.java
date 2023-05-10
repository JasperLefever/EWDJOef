package com.springboot.restExample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import perform.PerformRestExample;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@SpringBootApplication
public class SpringBootRestExample1Application implements WebMvcConfigurer {

	public static void main(String[] args){
		SpringApplication.run(SpringBootRestExample1Application.class, args);
		
		try {
			new PerformRestExample();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addRedirectViewController("/", "/rest/emp/dummy");
    }

	@Bean
	EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
}
