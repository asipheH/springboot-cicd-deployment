package com.example.cicd;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CicdApplicationTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeEndpointShouldReturnSuccessMessage() throws Exception{
        mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string("Spring Boot CI/CD Deployment Successful!"));
    }

    @Test
    void healthEndpointShouldConfirmApplicationIsRunning() throws Exception{
        mockMvc.perform(get("/health"))
        .andExpect(status().isOk())
        .andExpect(content().string("Application is Running"));
    }
}