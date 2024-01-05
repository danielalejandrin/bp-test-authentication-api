package com.bp.test.authentication.service;

import com.bp.test.authentication.service.dto.AuthenticationRequest;
import com.bp.test.authentication.service.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(request.username()))
                .build();
    }
}
