package com.springBoot.spring_boot_bank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import domain.BankCustomer;
import domain.BankCustomerLookup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;


public class BankControllerMockTest {

	private BankController controller;
    private MockMvc mockMvc;

    @Mock
    private BankCustomerLookup mock;


    @BeforeEach
    public void before() {
    	MockitoAnnotations.openMocks(this);
        controller = new BankController();
        mockMvc = standaloneSetup(controller).build();
      //injectie:
        ReflectionTestUtils.setField(controller, "bankCustomerLookup", mock);
    }

    @Test
    public void testPost_posBalance() throws Exception {
        BankCustomer expResult = new BankCustomer("100", "jan", "piet", 100);
        Mockito.when(mock.getCustomer("100")).thenReturn(expResult);

        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("100")))
                .andExpect(view().name("balance"))
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", expResult));

    }

    @Test
    public void testPost_negBalance() throws Exception {
        BankCustomer expResult = new BankCustomer("105", "piet", "af", -100);
        Mockito.when(mock.getCustomer("105")).thenReturn(expResult);

        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("105")))
                .andExpect(view().name("negativeBalance"))
                .andExpect(model().attributeExists("customer"))
                .andExpect(model().attribute("customer", expResult));

    }

    @Test
    public void testPost_unknown() throws Exception {
        BankCustomer expResult = null;
        Mockito.when(mock.getCustomer("200")).thenReturn(expResult);

        mockMvc.perform(post("/bank").flashAttr("bankCustomer", new BankCustomer("200")))
                .andExpect(view().name("unknownCustomer"))
                .andExpect(model().attributeDoesNotExist("customer"));
    }

}