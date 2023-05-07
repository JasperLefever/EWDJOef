package configuration;

import domain.Audience;
import domain.CriticismEngine;
import domain.Singer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfiguration {

    @Bean
    Audience audience() {
        return new Audience();
    }

    @Bean
    Singer alicia() {
        return new Singer("Alicia Keys", "No One");
    }

    @Bean
    Singer mika() {
        return new Singer("Mika", "Relax");
    }

    @Bean
    Singer shakira() {
        return new Singer("Shakira", "Relax");
    }

    @Bean
    CriticismEngine criticismEngine() {
        String[] criticismPool = new String[3];
        criticismPool[0] = "I'm not being rude, but that was appalling.";
        criticismPool[1] = "You may be the least talented person in this show.";
        criticismPool[2] = "Do everyone a favor and keep your day job.";

        CriticismEngine criticismEngine = new CriticismEngine();
        criticismEngine.setCriticismPool(criticismPool);
        return criticismEngine;
    }
}
