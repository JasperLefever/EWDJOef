package main;

import configuration.BeanConfiguration;
import domein.GreetingService;
import domein.GreetingServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartUp {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(BeanConfiguration.class)) {

            var greeting = context.getBean("greetingService", GreetingService.class);

            System.out.println(greeting.sayGreeting());
        }

    }

}
