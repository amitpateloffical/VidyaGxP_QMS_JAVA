package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IAuthenticationSourceController;
import com.inn.qms.model.AuthenticationSource;
import com.inn.qms.service.IAuthenticationSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/AuthenticationSource")
@Slf4j
public class AuthenticationSourceControllerImpl implements IAuthenticationSourceController {

    @Autowired
private final IAuthenticationSourceService authenticationSourceService;

    public AuthenticationSourceControllerImpl(IAuthenticationSourceService authenticationSourceService) {
        this.authenticationSourceService = authenticationSourceService;
    }

    @PostMapping("/create")
    @Override
    public ResponseEntity<AuthenticationSource> createAuthSource(@RequestBody AuthenticationSource authenticationSource) {
        try {
            log.info("requested to create AuthenticationSource");
            AuthenticationSource createdAuthSource = authenticationSourceService.createAuthSource(authenticationSource);
            log.info("Created Successfully");
            return new ResponseEntity<AuthenticationSource>(createdAuthSource, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException("Error creating Authentication Source - " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<AuthenticationSource> updateAuthSource(@RequestBody AuthenticationSource authenticationSource, @PathVariable Long id) {
        try {
            log.info("requested to updated AuthenticationSource");
            AuthenticationSource updatedAuthSource = authenticationSourceService.updateAuthSource(authenticationSource, id);
            log.info("updated Successfully");
            return new ResponseEntity<>(updatedAuthSource, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Error updating Authentication Source - " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    @Override
    public List<AuthenticationSource> getAllAuthSource() {
        return authenticationSourceService.getAllAuthSource();
    }

    @GetMapping("/{id}")
    @Override
    public AuthenticationSource getAuthSourceById(@PathVariable Long id) {
        try {
            log.info("requested to get AuthenticationSource by id");
            return authenticationSourceService.getAuthSourceById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching Authentication Source by Id - " + e.getMessage());
        }
    }

    @GetMapping("/Name/{name}")
    @Override
    public AuthenticationSource getByname(@PathVariable String name) {
        try {
            log.info("requested to get AuthenticationSource by name");
            return authenticationSourceService.getByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching Authentication Source by Name - " + e.getMessage());
        }
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<AuthenticationSource> updateStatus(@RequestBody Map<String, String> requestBody, @PathVariable Long id) {
        try {
            // Retrieving authentication source by ID
            AuthenticationSource authSource1 = authenticationSourceService.getAuthSourceById(id);
            if (authSource1 == null) {
                // Log warning if authentication source not found
                log.warn("Authentication source with ID {} not found", id);
                return ResponseEntity.notFound().build();
            }

            // Update status only if status is provided
            if (requestBody.containsKey("status")) {
                String status = requestBody.get("status");
                // Setting the new status based on the status provided by the client
                authSource1.setStatus(status);
            }
            authSource1.setName(requestBody.get("name"));
            authSource1.setType(requestBody.get("type"));
            authSource1.setLdapPassword(requestBody.get("ldap"));
            authSource1.setSearchFilter(requestBody.get("searchFilter"));
            authSource1.setServerUrl(requestBody.get("serverUrl"));
            authSource1.setRootSuffix(requestBody.get("rootSuffix"));


            // Updating the status of the authentication source
            AuthenticationSource updatedAuthSource = authenticationSourceService.updateAuthSource(authSource1, id);

            // Log the status update
            log.info("Authentication source status updated with ID: {} to {}", id, authSource1.getStatus());

            return ResponseEntity.ok(updatedAuthSource);
        } catch (Exception e) {
            log.error("Error updating authentication source status", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    }
