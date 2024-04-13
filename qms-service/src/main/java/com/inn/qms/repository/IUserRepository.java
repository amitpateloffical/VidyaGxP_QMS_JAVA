package com.inn.qms.repository;

import com.inn.qms.model.ColumnNames;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.User;
import org.yaml.snakeyaml.tokens.Token;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {


    // Add custom query methods if needed
}
