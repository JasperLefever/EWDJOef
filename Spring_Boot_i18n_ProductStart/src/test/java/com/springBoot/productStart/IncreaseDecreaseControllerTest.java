package com.springBoot.productStart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IncreaseDecreaseControllerTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void testIn_DecreaseGet() throws Exception {

	        mockMvc.perform(get("/increaseDecrease"))
	                .andExpect(view().name("priceChange"))
	                .andExpect(model().attributeExists("price"));
	    }

	    @Test
	    public void testIn_DecreasePostIncorrect() throws Exception {

	        mockMvc.perform(post("/increaseDecrease")
	        )
	                .andExpect(view().name("priceChange"));
	    }

	    @Test
	    public void testIn_DecreasePostCorrect() throws Exception {

	        mockMvc.perform(post("/increaseDecrease")
	                .param("percentIncrease", "30")
	                .param("percentDecrease", "10")
	        )
	                //.andExpect(view().name("redirect:/inventory"));
	                .andExpect(view().name("redirect:/inventory?aangepast=20"));
	    }
	}
