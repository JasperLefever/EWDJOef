import configuration.BeanConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.MindReader;
import domain.Thinker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(BeanConfiguration.class)
class MagicianVolunteerTest {

	@Autowired
	private Thinker volunteer;

	@Autowired
	private MindReader magician;

	@Test
	public void magicianShouldReadVolunteersMind() {
		volunteer.thinkOfSomething("Queen of Hearts");
		Assertions.assertEquals("Queen of Hearts", magician.getThoughts());
	}

}
