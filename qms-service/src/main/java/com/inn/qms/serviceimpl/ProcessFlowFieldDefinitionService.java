package com.inn.qms.serviceimpl;

import com.inn.qms.model.ProcessFlowFieldDefinition;
import com.inn.qms.repository.IProcessFlowFieldDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessFlowFieldDefinitionService {
    @Autowired
    private IProcessFlowFieldDefinitionRepository processFlowFieldDefinitionRepository;

    public ProcessFlowFieldDefinition saveProcessFlowFieldDefinition(ProcessFlowFieldDefinition fieldDefinition) {
        return processFlowFieldDefinitionRepository.save(fieldDefinition);
    }

    // Add more methods as needed
}


