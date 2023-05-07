package configuration;

import domein.GreetingService;
import domein.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    GreetingService greetingService() {
        GreetingServiceImpl gr =  new GreetingServiceImpl();
        gr.setGreeting("Hello World!");
        return gr;
    }


}
