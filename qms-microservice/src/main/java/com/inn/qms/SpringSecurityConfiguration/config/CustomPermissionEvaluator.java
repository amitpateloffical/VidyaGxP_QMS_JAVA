package com.inn.qms.SpringSecurityConfiguration.config;

import com.inn.qms.SpringSecurityConfiguration.Entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomPermissionEvaluator  implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if (auth == null || permission == null) {
            return false;
        }

        // Assuming targetDomainObject is the user for whom the permission is being checked
        User user = (User) targetDomainObject; // Cast to the appropriate user object type

        // Logic to check if the current user has the specified permission for the target domain object
        // Example: Check if the user has the 'create_user' permission
        if (permission.equals("create_user")) {
            // Check if the user has the 'create_user' permission
            // Replace this with your actual permission checking logic
//        2
        }

        // Add additional permission checks as needed

        return false; // Default to denying permission if no specific permission check is implemented
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        User principal = (User) authentication.getPrincipal();


        return false;
    }

    // Implement other methods of the PermissionEvaluator interface as needed
}

