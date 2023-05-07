import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.springBoot_firstExample.HelloController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import domain.HelloService;

public class HelloControllerMockTest {

	private HelloController controller;

    private MockMvc mockMvc;

    @Mock
    private HelloService mock;


    @BeforeEach
    public void before() {
    	MockitoAnnotations.openMocks(this);
        controller = new HelloController();
        mockMvc = standaloneSetup(controller).build();
      //injectie:
        ReflectionTestUtils.setField(controller, "helloService", mock);
    }

    @Test
    public void testHelloPost() throws Exception {

        String expResult = "Hello testMock!";
        Mockito.when(mock.sayHello("test")).thenReturn(expResult);

        mockMvc.perform(post("/hello")
                .param("value", "test")
        )
                .andExpect(view().name("helloView"))
                .andExpect(model().attributeExists("helloMessage"))
                .andExpect(model().attribute("helloMessage", expResult));

    }
}