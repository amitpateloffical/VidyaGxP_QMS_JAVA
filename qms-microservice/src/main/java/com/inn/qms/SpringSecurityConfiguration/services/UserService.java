package com.inn.qms.SpringSecurityConfiguration.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();
}
