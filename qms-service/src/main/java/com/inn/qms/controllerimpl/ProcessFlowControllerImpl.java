package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IProcessFlowController;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.service.IProcessFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processFlow")
public class ProcessFlowControllerImpl implements IProcessFlowController {


    @Autowired
    IProcessFlowService processFlowService;
    @Override
    @PostMapping("/create")
    public ResponseEntity<ProcessFlow> createProcess(@RequestBody ProcessFlow processFlow) {
        ProcessFlow createdProcess =	processFlowService.createProcess(processFlow);
        return new ResponseEntity<>(createdProcess, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<ProcessFlow> updateProcess(@RequestBody ProcessFlow processFlow, @PathVariable long id) {
        ProcessFlow updatedProcess = processFlowService.updateProcess(processFlow, id);
        return new ResponseEntity<>(updatedProcess, HttpStatus.OK);
    }


    @Override
    @GetMapping("/{id}")
    public ProcessFlow getByIdDetails(@PathVariable ("id") Long id) {
        return processFlowService.getByIdProcessDetail(id);
    }

    @Override
    @GetMapping("/Name/{flowName}")
    public ProcessFlow getByNameDetails(@PathVariable ("flowName") String flowName) {
        return processFlowService.getByNameProcessDetail(flowName);
    }

    @Override
    @GetMapping("/alldetaills")
    public List<ProcessFlow> getAllDetails() {
        return processFlowService.getAllDetails();
    }


}
