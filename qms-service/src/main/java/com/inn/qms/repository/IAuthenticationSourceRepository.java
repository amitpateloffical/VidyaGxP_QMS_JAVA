package com.inn.qms.repository;

import com.inn.qms.model.AuthenticationSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationSourceRepository extends JpaRepository<AuthenticationSource,Long> {

    public AuthenticationSource findByname(String name);
}
