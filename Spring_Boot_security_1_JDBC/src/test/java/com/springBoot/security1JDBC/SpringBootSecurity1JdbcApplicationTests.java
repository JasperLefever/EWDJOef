package com.springBoot.security1JDBC;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@Import(SecurityConfig.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootSecurity1JdbcApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void loginGet() throws Exception {
	    	mockMvc.perform(get("/login"))
	        .andExpect(status().isOk())
	    	.andExpect(view().name("login"));
	}
	 
	@Test
	public void accessDeniedPageGet() throws Exception {
	    	mockMvc.perform(get("/403"))
	        .andExpect(status().isOk())
	    	.andExpect(view().name("403"));
	}
	 
	@WithMockUser(username = "user", roles = {"USER"})
    @Test
    public void testAccessWithUserRole() throws Exception {
        mockMvc.perform(get("/welcome"))
        .andExpect(status().isOk())
		.andExpect(view().name("hello"))
		.andExpect(model().attributeExists("username"))
		.andExpect(model().attribute("username", "user"));
    }
	
	@WithMockUser(username = "admin", roles = {"ADMIN", "NOT_USER_NOT_ADMIN"}) 
	@Test
    public void testNoAccess() throws Exception {
        mockMvc.perform(get("/welcome"))
            .andExpect(status().isForbidden());
	}
	
}
