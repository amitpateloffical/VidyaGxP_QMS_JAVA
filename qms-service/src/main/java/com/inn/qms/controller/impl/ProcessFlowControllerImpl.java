package com.inn.qms.controller.impl;

import com.inn.qms.controller.IProcessFlowController;
import com.inn.qms.model.ProcessAdditionalInfo;
import com.inn.qms.model.ProcessFlow;

import com.inn.qms.model.Site;
import com.inn.qms.service.IProcessFlowService;
import com.inn.qms.service.impl.ProcessFlowServiceImpl;
import org.slf4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProcessFlow")
public class ProcessFlowControllerImpl implements IProcessFlowController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessFlowControllerImpl.class);

    @Autowired
    private IProcessFlowService iProcessFlowService;

    @Override
    public String create(ProcessFlow processFlow) {
        logger.info("Inside ProcessFlowControllerImpl create method processflow:{}",processFlow);
        return iProcessFlowService.create(processFlow);
    }

    @Override
    public String create(Site site) {
        return iProcessFlowService.create(site);
    }

    @Override
    public String create(ProcessAdditionalInfo processAdditionalInfo) {
        return iProcessFlowService.create(processAdditionalInfo);

    }
}
