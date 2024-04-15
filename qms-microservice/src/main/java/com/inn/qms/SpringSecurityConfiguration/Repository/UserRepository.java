package com.inn.qms.SpringSecurityConfiguration.Repository;

import com.inn.qms.SpringSecurityConfiguration.Entities.Role;
import com.inn.qms.SpringSecurityConfiguration.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
