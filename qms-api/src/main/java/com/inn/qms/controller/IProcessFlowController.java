package com.inn.qms.controller;

import com.inn.qms.model.ProcessFlow;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProcessFlowController {

    ResponseEntity<ProcessFlow> createProcess(ProcessFlow processFlow);
    
    ResponseEntity<ProcessFlow> updateProcess( ProcessFlow processFlow, long id);

    public ProcessFlow getByIdDetails( Long id);

    public ProcessFlow getByNameDetails( String flowName);

    public List<ProcessFlow> getAllDetails();





}
