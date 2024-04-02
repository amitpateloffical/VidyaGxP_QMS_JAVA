package com.inn.qms.controller;

import com.inn.qms.model.ProcessAdditionalInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/ProcessFlowAddInfo")

public interface IProcessFlowAddInfoController {

    @PostMapping("/create")
    ProcessAdditionalInfo create(ProcessAdditionalInfo processAdditionalInfo);
    @GetMapping("/{id}")
    ProcessAdditionalInfo getById(long id);

    @GetMapping("/site-process-flows")
    List<Object[]> getSiteProcessFlows();

}
