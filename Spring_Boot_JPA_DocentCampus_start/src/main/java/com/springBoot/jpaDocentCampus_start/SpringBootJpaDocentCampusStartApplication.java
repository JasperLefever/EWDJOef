package com.springBoot.jpaDocentCampus_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.SchoolService;
import service.SchoolServiceImpl;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"domain"})
@ComponentScans({
	@ComponentScan("service"),
	@ComponentScan("domain"),
	@ComponentScan("repository")
})
public class SpringBootJpaDocentCampusStartApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDocentCampusStartApplication.class, args);
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
	   registry.addRedirectViewController("/", "/school");
    }
	
	@Bean
	SchoolService schoolservice() {
		return new SchoolServiceImpl();
	}
}
