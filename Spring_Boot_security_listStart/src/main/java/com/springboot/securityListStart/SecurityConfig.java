package com.springboot.securityListStart;

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
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("nameUser").password(encoder.encode("12345678")).roles("USER").and()
                .withUser("nameAdmin").password(encoder.encode("admin1234")).roles("ADMIN");
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().and().authorizeHttpRequests(requests -> requests.requestMatchers("/login**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/403**").permitAll()
                        .requestMatchers("/students/list").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/students/**").hasRole("ADMIN"))
                .formLogin(form -> form.defaultSuccessUrl("/students/list", true)
                        .loginPage("/login")).exceptionHandling().accessDeniedPage("/403");
        //.requestMatchers("students/{id}").hasRole("ADMIN")
        return http.build();

    }
}