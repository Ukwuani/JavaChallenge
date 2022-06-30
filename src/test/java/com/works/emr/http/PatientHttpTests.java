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
import org.springframework.web.context.WebApplicationContext;

import com.works.emr.EmrApplication;


@ActiveProfiles("http_test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmrApplication.class)
@WebAppConfiguration
public class PatientHttpTests {
  private MockMvc mockMvc;

  @Autowired
   WebApplicationContext webApplicationContext;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }

    @Test
    public void should_Fetch_Patient_At_Min_Age_Of_2_Successfully() throws Exception {
         mockMvc.perform( MockMvcRequestBuilders.get("/v1/api/patient?minAge=2")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }
}