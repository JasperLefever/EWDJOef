package com.springBoot.productStart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IncreaseDecreaseControllerIncorrectTest {

	@Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
	@MethodSource("addFixture")
	public void testIn_DecreasePostIncorrect(String increase, String decrease) throws Exception{
    	mockMvc.perform(post("/increaseDecrease")
                .param("percentIncrease", increase)
                .param("percentDecrease", decrease)
        )
                .andExpect(view().name("priceChange"));
	}

	private static Stream<Arguments> addFixture() {
		return Stream.of(
				Arguments.of("10", ""), 
				Arguments.of("", "20"),
				Arguments.of("","-1"), 
				Arguments.of("10", "-1"),
				Arguments.of("-1", "20"), 
				Arguments.of("10", "99"),
				Arguments.of("99", "20"), 
				Arguments.of("10", "0"),
				Arguments.of("0", "20"), 
				Arguments.of("10", "26"), 
				Arguments.of("51", "20"),
				Arguments.of("10", "20"),
				Arguments.of("20", "21"));
	}

}

