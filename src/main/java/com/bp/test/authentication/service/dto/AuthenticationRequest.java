package com.bp.test.authentication.service.dto;

import lombok.Builder;

@Builder
public record AuthenticationRequest (
        String username,
        String password
){
}
