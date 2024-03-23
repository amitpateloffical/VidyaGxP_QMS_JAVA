package com.inn.qms.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.inn.qms.controller.IProcessFlowAddInfoController;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.service.IProcessFlowAddInfoService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
