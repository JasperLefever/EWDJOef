import java.util.stream.Stream;

import domain.HelloService;
import domain.HelloServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HelloServiceTest {

	private HelloService helloService;

    @BeforeEach
    public void before() {
        helloService = new HelloServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("addFixture")
    public void add(String input, String expResult) {
    	Assertions.assertEquals(expResult, helloService.sayHello(input));
    }

    private static Stream<Arguments> addFixture() {
      return Stream.of(
        Arguments.of("", "Hello !"),
        Arguments.of(null, "Hello !"),
        Arguments.of("   ", "Hello    !"),
        Arguments.of("test", "Hello test!"),
        Arguments.of("* TeST tEsT +", "Hello * TeST tEsT +!"));
    }

}
