package com.bp.test.authentication.controller;

import com.bp.test.authentication.service.AuthenticationService;
import com.bp.test.authentication.service.dto.AuthenticationRequest;
import com.bp.test.authentication.service.dto.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/v1")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationService service;
    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request){
        log.info("Authenticating user: {}",request.username());
        return service.authenticate(request);
    }
}
