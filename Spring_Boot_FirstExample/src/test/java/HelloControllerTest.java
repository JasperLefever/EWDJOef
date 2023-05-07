import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.springBoot_firstExample.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHelloGet() throws Exception {

		mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(view().name("nameForm"))
				.andExpect(model().attributeExists("name"));
	}

	@Test
	public void testHelloPost() throws Exception {

		// mockMvc.perform(post("/hello").param("value", "test"))
		// OR
		mockMvc.perform(post("/hello").flashAttr("name", new Name("test")))

				.andExpect(status().isOk()).andExpect(view().name("helloView"))
				.andExpect(model().attributeExists("helloMessage"))
				.andExpect(model().attribute("helloMessage", "Hello test!"));

	}
}
