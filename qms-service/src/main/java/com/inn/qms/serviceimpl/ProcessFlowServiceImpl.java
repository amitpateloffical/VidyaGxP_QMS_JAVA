package com.inn.qms.serviceimpl;

import  com.inn.qms.respository.IProcessFlowRepository;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.service.IProcessFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessFlowServiceImpl implements IProcessFlowService {

    @Autowired
    IProcessFlowRepository processFlowRepository;
    
    @Override
    public ProcessFlow createProcess(ProcessFlow processflow) {
        ProcessFlow createdProcess	= processFlowRepository.save(processflow);
        return createdProcess;
    }

    @Override
    public ProcessFlow updateProcess(ProcessFlow processflow,Long id) {
        ProcessFlow process = processFlowRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Process Not found"));

        process.setStatus(processflow.getStatus());
        process.setFlowName(processflow.getFlowName());
        processFlowRepository.save(process);
        return process;
    }



    @Override
    public ProcessFlow getByIdProcessDetail(Long id) {

        return processFlowRepository.findById(id).get();

    }

    @Override
    public ProcessFlow getByNameProcessDetail(String flowName) {

        return processFlowRepository.findByflowName(flowName);
    }

    @Override
    public List<ProcessFlow> getAllDetails() {
        return processFlowRepository.findAll();
    }
}
