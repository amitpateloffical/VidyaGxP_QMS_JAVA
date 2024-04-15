package com.inn.qms.SpringSecurityConfiguration.services;

import com.inn.qms.SpringSecurityConfiguration.Dto.JwtAuthenticationResponse;
import com.inn.qms.SpringSecurityConfiguration.Dto.RefreshTokenRequest;
import com.inn.qms.SpringSecurityConfiguration.Dto.SignUpRequest;
import com.inn.qms.SpringSecurityConfiguration.Dto.SigninRequest;
import com.inn.qms.SpringSecurityConfiguration.Entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
