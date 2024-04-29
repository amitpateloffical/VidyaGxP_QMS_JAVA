package com.inn.qms.controller;

import com.inn.qms.model.AuthenticationSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IAuthenticationSourceController
{
    ResponseEntity<AuthenticationSource> createAuthSource(AuthenticationSource authenticationSource);

    ResponseEntity<AuthenticationSource> updateAuthSource(AuthenticationSource authenticationSource, Long id);

    public List<AuthenticationSource> getAllAuthSource();
    public AuthenticationSource getAuthSourceById(Long id);
    public AuthenticationSource getByname(String name);
    public ResponseEntity<AuthenticationSource> updateStatus(Map<String, String> requestBody, Long id);
}
