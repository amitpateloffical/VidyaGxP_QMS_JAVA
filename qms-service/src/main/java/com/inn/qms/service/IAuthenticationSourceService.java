package com.inn.qms.service;

import com.inn.qms.model.AuthenticationSource;

import java.util.List;

public interface IAuthenticationSourceService
{
    public AuthenticationSource createAuthSource(AuthenticationSource authenticationSource);
    public AuthenticationSource updateAuthSource(AuthenticationSource authenticationSource, Long id);
    public List<AuthenticationSource> getAllAuthSource();
    public AuthenticationSource getAuthSourceById(Long id);
    public AuthenticationSource getByName(String name);

}
