package com.inn.qms.SpringSecurityConfiguration.Dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String token;
    private String refreshToken;
}
