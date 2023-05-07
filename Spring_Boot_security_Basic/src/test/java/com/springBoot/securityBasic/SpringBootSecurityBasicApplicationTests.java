package com.springBoot.securityBasic;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@Import(SecurityConfig.class)
class SpringBootSecurityBasicApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@WithMockUser(username = "user", roles = {"USER"})
    @Test
    public void testAccessWithUserRole() throws Exception {
        mockMvc.perform(get("/hello"))
        .andExpect(status().isOk())
        .andExpect(view().name("hello"))
        .andExpect(model().attributeExists("username"))
        .andExpect(model().attribute("username", "user"));
    }
	
	@WithMockUser(username = "user", roles = { "NOT_USER" })
    @Test
    public void testNoAccessWithWrongUserRole() throws Exception {
        mockMvc.perform(get("/hello"))
        .andExpect(status().isForbidden());
    }
	
	@Test
	public void testWrongPassword() throws Exception {
		mockMvc.perform(get("/hello").with(httpBasic("user", "wrongpassword")))
        .andExpect(status().isUnauthorized());
	}
	
	@Test
	public void testCorrectPassword() throws Exception {
		mockMvc.perform(get("/hello").with(httpBasic("user", "user")))
        .andExpect(status().isOk());
	}
		
}
