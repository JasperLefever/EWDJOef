package com.springBoot.security;

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
public class SecurityConfig{

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
          .withUser("nameUser").password(encoder.encode("12345678")).roles("USER");
    }
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http.csrf().and().
    	authorizeHttpRequests(requests -> 
    		requests.requestMatchers("/login**").permitAll()
    				.requestMatchers("/css/**").permitAll()
    				.requestMatchers("/*").hasRole("USER")).
    	formLogin(form -> 
    		form
    	            .defaultSuccessUrl("/welcome", true)
                	.loginPage("/login"));
    	
    	return http.build();
    	        
    }
}