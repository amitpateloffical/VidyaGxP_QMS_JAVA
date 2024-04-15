package com.inn.qms.SpringSecurityConfiguration.Controller;

import com.inn.qms.SpringSecurityConfiguration.Dto.JwtAuthenticationResponse;
import com.inn.qms.SpringSecurityConfiguration.Dto.RefreshTokenRequest;
import com.inn.qms.SpringSecurityConfiguration.Dto.SignUpRequest;
import com.inn.qms.SpringSecurityConfiguration.Dto.SigninRequest;
import com.inn.qms.SpringSecurityConfiguration.Entities.User;
import com.inn.qms.SpringSecurityConfiguration.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
