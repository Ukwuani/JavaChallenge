package com.works.emr.http;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import  org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SecurityConfig.class)
@WebAppConfiguration
public class HttpSecurityTests {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;


	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(SecurityMockMvcConfigurers.springSecurity()) 
				.build();
	}


	@Test
    public void should_Fail_Updating_Staff_Name_Without_Staff_UUID_TOKEN() throws Exception {
      mockMvc.perform( MockMvcRequestBuilders.put("/v1/api/staff/1")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{\"id\": 1, \"name\": \"Hope Doe\"}") 
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}