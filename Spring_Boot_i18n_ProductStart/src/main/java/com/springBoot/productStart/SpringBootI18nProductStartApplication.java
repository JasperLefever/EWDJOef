package com.springBoot.productStart;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import domain.Product;
import domain.ProductManager;
import domain.SimpleProductManager;
import validator.PercentValidation;

@SpringBootApplication
public class SpringBootI18nProductStartApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootI18nProductStartApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/inventory");
	}
    
	@Bean
    ProductManager productManager() {
        //zonder databank
        SimpleProductManager productManager = new SimpleProductManager();
        productManager.setProducts(List.of(new Product("Lamp", 5.751), 
        		new Product("Tafel", 75.2), new Product("Stoel", 22.791)));
        return productManager;
    }

	@Bean
	PercentValidation percentValidation() {
		return new PercentValidation();
	}
}
