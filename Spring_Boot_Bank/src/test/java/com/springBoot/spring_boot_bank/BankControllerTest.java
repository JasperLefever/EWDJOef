package com.springBoot.spring_boot_bank;

import domain.BankCustomer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetRequest() throws Exception {
        mockMvc.perform(get("/bank")).andExpect(status().isOk()).andExpect(view().name("form"))
                .andExpect(model().attributeExists("bankCustomer"));
    }

    @Test
    public void testPostRequest_positiveBank() throws Exception {
        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("123")))
                .andExpect(status().isOk())
				.andExpect(view().name("balance"))
                .andExpect(model().attributeExists("customer"));

    }

    @Test
    public void testPostRequest_negativeBank() throws Exception {
        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("789")))
                .andExpect(status().isOk())
				.andExpect(view().name("negativeBalance"))
                .andExpect(model().attributeExists("customer"));

    }


    @Test
    public void testPostRequest_nonExistent() throws Exception {
        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("111")))
                .andExpect(status().isOk())
				.andExpect(view().name("unknownCustomer"))
				.andExpect(model().attributeDoesNotExist("customer"));

    }
}
