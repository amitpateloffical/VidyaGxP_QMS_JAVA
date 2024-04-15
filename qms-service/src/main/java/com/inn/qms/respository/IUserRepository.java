package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ColumnNames;
import com.inn.qms.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	// Add custom query methods if needed
	
	User findByUserName(String userName);
}
