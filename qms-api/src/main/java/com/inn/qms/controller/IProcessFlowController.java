package com.inn.qms.controller;

import com.inn.qms.model.ProcessFlow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/processFlow")
public interface IProcessFlowController {

    @PostMapping("/create")
    ResponseEntity<ProcessFlow> createProcess(@RequestBody ProcessFlow processFlow);

    @PutMapping("/update/{id}")
    ResponseEntity<ProcessFlow> updateProcess( @RequestBody ProcessFlow processFlow, @PathVariable ("id") long id);

    @GetMapping("/{id}")
    public ProcessFlow getByIdDetails( @PathVariable ("id") Long id);

    @GetMapping("/Name/{flowName}")
    public ProcessFlow getByNameDetails(@PathVariable ("flowName") String flowName);

    @GetMapping("/alldetaills")
    public List<ProcessFlow> getAllDetails();





}
