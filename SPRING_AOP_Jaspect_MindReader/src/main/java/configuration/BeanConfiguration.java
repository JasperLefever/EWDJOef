package configuration;

import domain.Magician;
import domain.Volunteer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

    @Bean
    Magician magician() {
        return new Magician();
}

    @Bean
    Volunteer volunteer() {
        return new Volunteer();
    }

}