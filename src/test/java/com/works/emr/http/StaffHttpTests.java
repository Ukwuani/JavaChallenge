package com.works.emr.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

import com.works.emr.EmrApplication;


@ActiveProfiles("http_test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmrApplication.class)
@WebAppConfiguration
class StaffHttpTest {
  private MockMvc mockMvc;

  @Autowired
   WebApplicationContext webApplicationContext;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }

    @Test
    public void should_Create_StaffAccount_Successfully() throws Exception {
         mockMvc.perform( MockMvcRequestBuilders.post("/v1/api/staff")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{ \"name\": \"Jane Doe\", \"registration_date\": \"2022-06-29\" }") 
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(MockMvcResultMatchers.status().isCreated())
              .andExpect(MockMvcResultMatchers.jsonPath("$.uuid").exists())
              .andReturn();
    }

    @Test
    public void should_Update_Staff_Name_Successfully() throws Exception {
      mockMvc.perform( MockMvcRequestBuilders.put("/v1/api/staff/1")
              .contentType(MediaType.APPLICATION_JSON)
              .content("{\"id\": 1, \"name\": \"Hope Doe\"}") 
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }
}