package com.inn.qms.SpringSecurityConfiguration.Dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
