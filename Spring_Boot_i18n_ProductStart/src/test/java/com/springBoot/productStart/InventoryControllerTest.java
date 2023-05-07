package com.springBoot.productStart;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class InventoryControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testInventoryGet() throws Exception {

        mockMvc.perform(get("/inventory"))
                .andExpect(view().name("productOverview"))
                .andExpect(model().attributeExists("productList"));
    }

    
}