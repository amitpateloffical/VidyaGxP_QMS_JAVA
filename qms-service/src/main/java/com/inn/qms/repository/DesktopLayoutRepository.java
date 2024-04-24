package com.inn.qms.repository;

import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesktopLayoutRepository extends JpaRepository<DesktopLayoutDetails, Long> {
    boolean existsByname(String layoutName);

    Optional<DesktopLayoutDetails> findByName(String name);
}
