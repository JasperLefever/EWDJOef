package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import domain.Operation;
import domain.OperationAdd;
import domain.ResultWriter;
import domain.ScreenWriter;
import spring_wiring.CalculateSpring;

@Configuration
public class FirstExampleConfiguration {

    @Bean
    ResultWriter resultWriter() {
        return new ScreenWriter();
    }

    @Bean
    Operation operation() {
        return new OperationAdd();
    }

    @Bean
    CalculateSpring opsbean() {
        CalculateSpring calculate = new CalculateSpring();
        calculate.setOps(operation());
        calculate.setWriter(resultWriter());
        return calculate;
    }
}