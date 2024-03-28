package com.inn.qms.serviceimpl;

import  com.inn.qms.respository.IProcessFlowRepository;
import com.inn.qms.Exception1.DataNotFoundException;
import com.inn.qms.Respository.IProcessFlowRepository;

import com.inn.qms.model.ProcessFlow;
import com.inn.qms.service.IProcessFlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProcessFlowServiceImpl implements IProcessFlowService {

    @Autowired
    IProcessFlowRepository processFlowRepository;


    @Override
    public ProcessFlow createProcess(ProcessFlow processflow) {

        try {
            if (processflow == null) {
                throw new NullPointerException("ProcessFlow object is null");
            }

            if (processflow.getFlowName() == null) {
                throw new com.inn.qms.Exception1.DataNotFoundException("Flow name is null");
            }

            if (processflow.getStatus() == null) {
                throw new com.inn.qms.Exception1.DataNotFoundException("Status is null");
            }

            // Add checks for other fields

            ProcessFlow createdProcess = processFlowRepository.save(processflow);
            return createdProcess;

        } catch (NullPointerException ex) {
            throw new RuntimeException("Error creating process flow - " + ex.getMessage());
        }
    }

    @Override
    public ProcessFlow updateProcess(ProcessFlow processflow, Long id) {
        try {
            if (processFlowRepository.findById(id).isEmpty()) {
                throw new DataNotFoundException("Requested Processflow Id does not exist");
            }

            ProcessFlow updated = processFlowRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("ProcessFlow not found"));

            updated.setFlowName(processflow.getFlowName());
            processFlowRepository.save(updated);

           log.info("Updated Process Flow with id {}: {}", id, updated);
            return updated;
        } catch (Exception ex) {
           log.error("Error updating process flow with id {}", id, ex);
            throw ex;
        }

    }

    @Override
   public ProcessFlow getByIdProcessDetail(Long id) {

  try {

    if(processFlowRepository.findById(id).isEmpty()) {
      throw new DataNotFoundException("Requested Flow-id does not exist");
    }

    return processFlowRepository.findById(id).get();

  } catch (DataNotFoundException ex) {
    log.info("Process not found for id: " + ex);
    throw ex;

  } catch (Exception ex) {
    // handle other exceptions
   log.info("Error getting process flow  "+ ex);
    throw ex;
  }

}

    @Override
    public ProcessFlow getByNameProcessDetail(String flowName) {

      try {
          ProcessFlow getByNameData = processFlowRepository.findByflowName(flowName);

          if (getByNameData == null)
              throw new com.inn.qms.Exception1.DataNotFoundException("Requested Flow-Name is dose not exist");

          return getByNameData;
      }
      catch (DataNotFoundException ex)
      {
        log.info("Process not found :"+ ex);
          throw ex;
      }
      catch (Exception ex)
      {
       log.info("Error getting process flow  "+ex);
       throw ex;
      }
    }

    @Override
    public List<ProcessFlow> getAllDetails() {
        return processFlowRepository.findAll();
    }
}
