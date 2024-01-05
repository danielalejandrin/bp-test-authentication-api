package com.bp.test.authentication.controller;

import com.bp.test.authentication.service.AuthenticationService;
import com.bp.test.authentication.service.dto.AuthenticationRequest;
import com.bp.test.authentication.service.dto.AuthenticationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private AuthenticationService service;

    @Test
    void shouldReturnAToken() throws Exception {
        //given
        var authRequest = AuthenticationRequest.builder()
                .username("username")
                .password("password")
                .build();
        var authResponse = AuthenticationResponse.builder()
                .token("dummyToken")
                .build();
        Mockito.when(service.authenticate(Mockito.any(AuthenticationRequest.class)))
                .thenReturn(authResponse);
        RequestBuilder request  = MockMvcRequestBuilders.post("/api/auth/v1/authenticate")
                .content(mapper.writeValueAsString(authRequest))
                .contentType(MediaType.APPLICATION_JSON);
        //when
        ResultActions response = mockMvc.perform(request);
        //then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").exists());
    }
}
