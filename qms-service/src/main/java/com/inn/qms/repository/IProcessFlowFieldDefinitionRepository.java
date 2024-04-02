package com.inn.qms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.qms.model.ProcessFlowFieldDefinition;

@Repository
public interface IProcessFlowFieldDefinitionRepository extends JpaRepository<ProcessFlowFieldDefinition, Long> {
    // Add custom query methods if needed
}

