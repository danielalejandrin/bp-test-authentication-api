package com.bp.test.authentication.service.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String token
) {
}
