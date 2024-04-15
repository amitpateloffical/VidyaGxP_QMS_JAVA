package com.inn.qms.controllerimpl;

import com.inn.qms.controller.IProcessFlowAddInfoController;
import com.inn.qms.controller.IProcessFlowController;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;
import com.inn.qms.service.IProcessFlowAddInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Override
    @GetMapping("/getAll")
    public List<ProcessAdditionalInfo> getAllDetails() {
        return iProcessFlowAddInfoService.getAllDetails();
    }

    @GetMapping("/getAdd")
    public List<ProcessAdditionalInfo> getSiteProcessFlows()
    {
        return iProcessFlowAddInfoService.getSiteProcessFlows();
    }




}
