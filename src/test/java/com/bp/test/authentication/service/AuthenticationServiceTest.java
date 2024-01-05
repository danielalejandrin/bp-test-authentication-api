package com.bp.test.authentication.service;

import com.bp.test.authentication.service.dto.AuthenticationRequest;
import com.bp.test.authentication.service.dto.AuthenticationResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

 @InjectMocks
 private AuthenticationService service;
 @Mock
 private JwtService jwtService;

 @Test
 void shouldReturnAResponseWithToken() {
  //given
  var authRequest = AuthenticationRequest.builder()
          .username("username")
          .password("password")
          .build();
  Mockito.when(jwtService.generateToken("username"))
          .thenReturn("dummyToken");
  //when
  AuthenticationResponse authResponse = service.authenticate(authRequest);
  //then
  Assertions.assertThat(authResponse.token()).isEqualTo("dummyToken");
 }
}
