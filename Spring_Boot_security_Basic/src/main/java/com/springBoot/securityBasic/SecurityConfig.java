package com.springBoot.securityBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    
    	PasswordEncoder encoder =  PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("user").password(encoder.encode("user")).roles("USER").and()
          .withUser("admin").password(encoder.encode("admin")).roles("USER","ADMIN");
    }
    
	//NoOpPasswordEncoder
    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    
        auth
                // enable in memory based authentication with a user named
                // "user" and "admin"
                .inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER").and()
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN");
    }*/
    	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       
       http.authorizeHttpRequests(requests -> 
       			requests.requestMatchers("/*")
       					.hasRole("USER")).
       httpBasic();
       
       return http.build();
       
		/*OR different syntax:
		  http.authorizeHttpRequests() 
       		.requestMatchers("/*")
       		.hasRole("USER")
          .and()
          .httpBasic();
   
          return http.build();*/
  
    }
}