package com.tribe.task.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tribe.task.dto.FactorialRequest;
import com.tribe.task.dto.FactorialResponse;
import com.tribe.task.services.FactorialCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FactorialController.class)
public class FactorialControllerTests {

    @MockBean
    private FactorialCalculator service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void FactorialController_GetFactorialRequest() throws Exception {
        FactorialRequest request = new FactorialRequest(5);
        String requestJson = objectMapper.writeValueAsString(request);
        FactorialResponse expected = new FactorialResponse(BigInteger.valueOf(120));
        String expectedJson = objectMapper.writeValueAsString(expected);

        given(service.calculateFactorial(any(FactorialRequest.class))).willReturn(expected);

        mockMvc.perform(get("/factorial")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))

                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
        verify(service, times(1)).calculateFactorial(any());
    }

    @Test
    public void FactorialController_InvalidRequest_IllegalData() throws Exception {
        FactorialRequest request = new FactorialRequest(-5);

        mockMvc.perform(get("/factorial")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))

                .andExpect(status().isBadRequest());

        verify(service, times(0)).calculateFactorial(any());
    }

    @Test
    public void FactorialController_InvalidRequest_DataGreaterThan100() throws Exception {
        FactorialRequest request = new FactorialRequest(101);

        mockMvc.perform(get("/factorial")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))

                .andExpect(status().isBadRequest());

        verify(service, times(0)).calculateFactorial(any());
    }

    @Test
    public void FactorialController_InvalidRequest_NullData() throws Exception {
        FactorialRequest request = new FactorialRequest(null);

        mockMvc.perform(get("/factorial")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))

                .andExpect(status().isBadRequest());

        verify(service, times(0)).calculateFactorial(any());
    }
}

