import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import configuration.FirstExampleConfiguration;
import domain.Operation;
import domain.OperationAdd;
import domain.ScreenWriter;
import spring_wiring.CalculateSpring;

@SpringJUnitWebConfig(FirstExampleConfiguration.class)
class CalculateSpringTest {

	@Autowired
	private CalculateSpring calculateSpring;

	@Test
	public void test() {
		Operation op = calculateSpring.getOps();
		Assertions.assertTrue(op instanceof OperationAdd);
		Assertions.assertTrue(calculateSpring.getWriter() instanceof ScreenWriter);
		Assertions.assertEquals(300, op.operate(100, 200));
	}

}
