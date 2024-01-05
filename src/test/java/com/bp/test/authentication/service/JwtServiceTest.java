package com.bp.test.authentication.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
    }

    @Test
    void shouldReturnAValidToken() {
        //given

        //when
        String token = jwtService.generateToken("username");
        //then
        Assertions.assertThat(token).matches(Pattern.compile("^([A-Za-z0-9_-]+)\\.([A-Za-z0-9_-]+)\\.([A-Za-z0-9_-]+)$"));
    }
}
