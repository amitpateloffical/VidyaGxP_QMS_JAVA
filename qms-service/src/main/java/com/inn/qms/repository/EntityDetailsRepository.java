package com.inn.qms.repository;

import com.inn.qms.model.EntityDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntityDetailsRepository extends JpaRepository<EntityDetails, Long> {
    Optional<EntityDetails> findByName(String name);
}

