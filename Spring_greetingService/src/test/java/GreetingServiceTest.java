import configuration.BeanConfiguration;
import domein.GreetingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(BeanConfiguration.class)
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void test() {
        Assertions.assertEquals("Hello World!", greetingService.sayGreeting());
    }
}
