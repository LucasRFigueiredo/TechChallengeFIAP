package com.techchallenge.lanchonete.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ApiCheckController.class)
@AutoConfigureMockMvc
public class ApiCheckControllerTest {

    @MockBean
    private ApiCheckController apiCheckController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHealthCheckEndpoint() throws Exception {
        mockMvc.perform(get("/healthcheck/health"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}