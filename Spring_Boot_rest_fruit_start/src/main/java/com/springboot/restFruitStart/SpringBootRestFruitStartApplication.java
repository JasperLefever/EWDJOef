package com.springboot.restFruitStart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import perform.PerformRestFruit;
import service.FruitService;
import service.FruitServiceImpl;

@SpringBootApplication
public class SpringBootRestFruitStartApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestFruitStartApplication.class, args);
	
		try {
			new PerformRestFruit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addRedirectViewController("/", "/fruit/all");
    }
	
	@Bean
    FruitService fruitService() {
        return new FruitServiceImpl();
    }
}
