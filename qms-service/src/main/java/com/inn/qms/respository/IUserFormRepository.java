package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.UserForm;

@Repository
public interface IUserFormRepository extends JpaRepository<UserForm, Long> {
	// Add custom query methods if needed
}
