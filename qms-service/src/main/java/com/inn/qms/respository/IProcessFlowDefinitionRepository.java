package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ProcessFlowDefinition;

@Repository
public interface IProcessFlowDefinitionRepository extends JpaRepository<ProcessFlowDefinition, Long> {
    // Add custom query methods if needed
}

