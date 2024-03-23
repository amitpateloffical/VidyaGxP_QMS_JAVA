package com.inn.qms.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.qms.controller.IProcessFlowAddInfoController;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.service.IProcessFlowAddInfoService;

@RestController
@RequestMapping("/ProcessFlowAddInfo")
public class ProcessFlowAddInfoControllerImpl implements IProcessFlowAddInfoController {

    @Autowired
    private IProcessFlowAddInfoService iProcessFlowAddInfoService;
    
    @Override
    @PostMapping("/create")
    public ProcessAdditionalInfo create(@RequestBody ProcessAdditionalInfo processAdditionalInfo) {
        return iProcessFlowAddInfoService.create(processAdditionalInfo);
    }

    @Override
    @GetMapping("/{id}")
    public ProcessAdditionalInfo getById(@PathVariable("id") long id) {

        return  iProcessFlowAddInfoService.getByIdAllDetails(id);
    }




}
