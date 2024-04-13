package com.inn.qms.controllerimpl;

import com.inn.qms.model.ProcessFlowFieldDefinition;
import com.inn.qms.serviceimpl.ProcessFlowFieldDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProcessFlowFieldDefinitionController {
    @Autowired
    private ProcessFlowFieldDefinitionService processFlowFieldDefinitionService;

    @PostMapping("/create")
    public ResponseEntity<ProcessFlowFieldDefinition> createProcessFlowFieldDefinition
            (@RequestBody ProcessFlowFieldDefinition fieldDefinition) {
        ProcessFlowFieldDefinition savedFieldDefinition = processFlowFieldDefinitionService
                .saveProcessFlowFieldDefinition(fieldDefinition);
        return new ResponseEntity<>(savedFieldDefinition, HttpStatus.CREATED);
    }

    // Add more endpoints as needed
}
