package com.bp.test.authentication.service;

import com.bp.test.authentication.service.dto.AuthenticationRequest;
import com.bp.test.authentication.service.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        return AuthenticationResponse.builder()
                .token("dummyToken")
                .build();
    }
}
