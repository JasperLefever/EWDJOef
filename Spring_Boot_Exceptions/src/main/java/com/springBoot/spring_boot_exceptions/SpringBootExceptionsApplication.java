package com.springBoot.spring_boot_exceptions;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import web.MeasurementInterceptor;

@SpringBootApplication
public class SpringBootExceptionsApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionsApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/welcome");
	}
	
	@Bean
    SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        mappings.put("exception.ReservationNotAvailableException", 
        		     "error/reservationNotAvailable");
        mappings.put("java.lang.NumberFormatException", 
                "error/generic_error");

        r.setDefaultErrorView("error/error");
        r.setExceptionMappings(mappings);
        return r;
    }

    @Bean
    MeasurementInterceptor measurementInterceptor() {
        return new MeasurementInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(measurementInterceptor()).
                addPathPatterns("/welcome");
    }

}
