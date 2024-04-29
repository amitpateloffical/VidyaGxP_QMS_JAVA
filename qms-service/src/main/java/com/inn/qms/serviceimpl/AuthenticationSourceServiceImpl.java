package com.inn.qms.serviceimpl;

import com.inn.qms.exception.BusinessException;
import com.inn.qms.model.AuthenticationSource;
import com.inn.qms.repository.IAuthenticationSourceRepository;
import com.inn.qms.service.IAuthenticationSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AuthenticationSourceServiceImpl implements IAuthenticationSourceService {

    @Autowired
    private IAuthenticationSourceRepository authenticationSourceRepository;

    @Override
    public AuthenticationSource createAuthSource(AuthenticationSource authenticationSource) {
        validateAuthenticationSource(authenticationSource);

        authenticationSource.setStatus("Active");

        AuthenticationSource createdAuthSource = authenticationSourceRepository.save(authenticationSource);

        return createdAuthSource;
    }

    @Override
    public AuthenticationSource updateAuthSource(AuthenticationSource authenticationSource, Long id) {
        try {
            if (authenticationSourceRepository.findById(id).isEmpty()) {
                throw new BusinessException("Please provide the valid Authentication Source id");
            }
            AuthenticationSource authData = authenticationSourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Site not found"));

            authData.setName(authenticationSource.getName());
            authData.setType(authenticationSource.getType());
            authData.setRootSuffix(authenticationSource.getRootSuffix());
            authData.setSearchFilter(authenticationSource.getSearchFilter());
            authData.setServerUrl(authenticationSource.getServerUrl());
            authData.setLdapUserName(authenticationSource.getLdapUserName());
            authData.setLdapPassword(authenticationSource.getLdapPassword());

            authenticationSourceRepository.save(authData);

            log.info("Updated Process Flow with id {}: {}", id, authData);

            return authData;
        } catch (Exception e) {
            log.error("Error updating process flow with id {}", id, e);
            throw e;
        }
    }

    @Override
    public List<AuthenticationSource> getAllAuthSource() {
        return authenticationSourceRepository.findAll();
    }

    @Override
    public AuthenticationSource getAuthSourceById(Long id) {
        try {
            if (authenticationSourceRepository.findById(id).isEmpty()) {
                throw new BusinessException("Please provide the valid Authentication Source id");
            }
            return authenticationSourceRepository.findById(id).get();
        } catch (Exception e) {
            log.info("Error getting process flow  "+ e);
            throw e;
        }
    }

    @Override
    public AuthenticationSource getByName(String name) {
        try {
            AuthenticationSource authenticationSourceName = authenticationSourceRepository.findByname(name);

            if (authenticationSourceName == null)
                throw new BusinessException("Please provide the valid Authentication Source Name");

                return authenticationSourceName;
        }
        catch (BusinessException ex)
        {
            log.info("Process not found :"+ ex);
            throw ex;
        }
        catch (Exception e) {
            log.info("Error getting process flow  "+e);
            throw e;
        }
    }

    private void validateAuthenticationSource(AuthenticationSource authenticationSource) {
        if (authenticationSource == null) {
            throw new NullPointerException("Authentication Source object is null");
        }
        if (authenticationSource.getName() == null) {
            throw new BusinessException("Please provide the Name");
        }
        if (authenticationSource.getRootSuffix() == null) {
            throw new BusinessException("Please provide the RootSuffix");
        }
        if (authenticationSource.getServerUrl() == null) {
            throw new BusinessException("Please provide the ServerUrl");
        }
        if (authenticationSource.getLdapUserName() == null) {
            throw new BusinessException("Please provide the LdapUserName");
        }
    }
}
