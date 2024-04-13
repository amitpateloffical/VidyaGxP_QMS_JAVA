package com.inn.qms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.UserForm;

@Repository
public interface IUserFormRepository extends JpaRepository<UserForm, Long> {
	// Add custom query methods if needed
    default UserForm saveJson(String userFormJson) {
        // Implementation logic to save JSON string to the database
        return null; // Placeholder return
    }

    // Placeholder for the findJsonById method mentioned in the service
    default String findJsonById(Long id) {
        // Implementation logic to retrieve JSON string from the database
        return null; // Placeholder return
    }

}
