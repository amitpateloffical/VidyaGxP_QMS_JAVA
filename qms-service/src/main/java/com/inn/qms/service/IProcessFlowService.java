package com.inn.qms.service;

import com.inn.qms.model.ProcessFlow;

import java.util.List;

public interface IProcessFlowService {

    public ProcessFlow createProcess(ProcessFlow processflow);
    public ProcessFlow updateProcess(ProcessFlow processflow,Long id);
    //public ProcessFlow updateProcess(ProcessFlow processflow);
    public ProcessFlow getByIdProcessDetail(Long id);
    public ProcessFlow getByNameProcessDetail(String flowName);
    public List<ProcessFlow> getAllDetails();
}
