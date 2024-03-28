package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IProcessFlowController;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.service.IProcessFlowService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/processFlow")
@Slf4j

public class ProcessFlowControllerImpl implements IProcessFlowController {
    @Autowired
    IProcessFlowService processFlowService;
   
    @Override
    public ResponseEntity<ProcessFlow> createProcess(ProcessFlow processFlow) {

     log.info("requested to create processFlow");

        ProcessFlow createdProcess =	processFlowService.createProcess(processFlow);
        log.info("Created Successfully");

        return new ResponseEntity<>(createdProcess, HttpStatus.CREATED);
    }

    @Override
public ResponseEntity<ProcessFlow> updateProcess(ProcessFlow processFlow, long id) {

        try {
            processFlow.setId(id);
            ProcessFlow updatedProcessFlow = processFlowService.updateProcess(processFlow,id);

            if (updatedProcessFlow != null) {
              log.info("ProcessFlow updated successfully: " + updatedProcessFlow.toString());
                return new ResponseEntity<>(updatedProcessFlow, HttpStatus.OK);
            } else {
                log.info("Failed to update site with ID " + id);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
          log.info("Failed to update processFlow with Id "+id);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

}



    @Override
   public ProcessFlow getByIdDetails(Long id) {

  try {
    ProcessFlow getById = processFlowService.getByIdProcessDetail(id);
    if(getById != null){
       log.info("ProcessFlow found by Id : "+id);
      return getById;
    } else {
     log.warn("ProcessFlow Not found by Id : "+id);
      return getById;
    }
  } catch (Exception e) {
   log.info("Error getting ProcessFlow by id  :  "+e);
    throw e;
  }

}

    @Override
    public ProcessFlow getByNameDetails(String flowName) {
        try {
            ProcessFlow getByName = processFlowService.getByNameProcessDetail(flowName);
            if(getByName != null){
               log.info("ProcessFlow found by Id : "+flowName);
                return getByName;
            } else {
               log.warn("ProcessFlow Not found by Id : "+flowName);
                return getByName;
            }
        } catch (Exception e) {
           log.info("Error getting ProcessFlow by id  :  "+e);
            throw e;
        }
    }

    @Override
    @GetMapping("/Name/{flowName}")
    public ProcessFlow getByNameDetails(@PathVariable ("flowName") String flowName) {
        return processFlowService.getByNameProcessDetail(flowName);
    }

    @Override
    @GetMapping("/alldetails")
    public List<ProcessFlow> getAllDetails() {
         log.info("Request to get all Processflow Data");
        return processFlowService.getAllDetails();
    }
}
